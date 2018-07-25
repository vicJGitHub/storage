package com.hywa.bigdata.storage.validate;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

//运行期保留
@Retention(RetentionPolicy.RUNTIME)
//作用于方法上
@Target(ElementType.METHOD)
@Documented
@Component
@Scope("prototype")
public @interface JsonValidate {

    Class<?> value();
}
