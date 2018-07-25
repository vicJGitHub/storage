package com.hywa.bigdata.storage.aop;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.redis.RedisUser;
import com.hywa.bigdata.storage.entity.User;
import com.hywa.bigdata.storage.exception.GlobalException;
import com.hywa.bigdata.storage.validate.JsonValidate;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


//用以校验登陆状态的aop
@Component
@Aspect
public class ControllerAop {


    @Autowired
    RedisUser redisUser;

    //使用前置通知,通过抛异常的形式返回统一值
    @Before("execution (* com.hywa.bigdata.storage.controller..*.*(..))")
    @Order(1)
    public void loginValidation() {
        User user = redisUser.getUser();
        if (null == user) {
            throw new GlobalException(1, "请登陆后再进行相关操作");
        }


    }


    //注解式表单验证
    @Around("@annotation(com.hywa.bigdata.storage.validate.JsonValidate)")
    @Order(2)
    public Object formValidation(ProceedingJoinPoint point) throws Throwable {
        //获得参数值
        List<Object> objects = Arrays.asList(point.getArgs());
        //读取valid结构交由aop统一管理
        BindingResult bindingResult = null;
        for (Object arg : point.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
            }
        }
        if (bindingResult != null) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            if (errors.size() > 0) {
                StringBuilder msg = new StringBuilder();
                for (ObjectError error : errors) {
                    msg.append(error.getDefaultMessage());
                    break;
                }
                return new AjaxJson(1, msg.toString());
            }
        }
        //获得对象方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        JsonValidate annotation = method.getAnnotation(JsonValidate.class);
        //通过反射调用注解中的方法
        Class<?> clazz = Class.forName(annotation.value().getName());
        Method clazzMethod = clazz.getMethod("validate", Object.class);
        Object invoke = clazzMethod.invoke(clazz.newInstance(), point.getArgs()[0]);
        if (null != invoke) {
            return invoke;
        }
        return point.proceed();
    }

}