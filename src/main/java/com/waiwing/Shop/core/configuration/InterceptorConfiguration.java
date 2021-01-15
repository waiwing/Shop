package com.waiwing.Shop.core.configuration;

import com.waiwing.Shop.core.interceptors.PermissionInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class InterceptorConfiguration implements WebMvcConfigurer{
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new PermissionInterceptor());

    }
}
