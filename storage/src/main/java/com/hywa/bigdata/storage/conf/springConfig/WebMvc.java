package com.hywa.bigdata.storage.conf.springConfig;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebMvc {

    /**
     * 配置过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("originFilter");
        return registration;
    }

    /**
     * 创建一个bean
     *
     * @return
     */
    @Bean(name = "originFilter")
    public Filter sessionFilter() {
        return new OriginFilter();
    }

}
