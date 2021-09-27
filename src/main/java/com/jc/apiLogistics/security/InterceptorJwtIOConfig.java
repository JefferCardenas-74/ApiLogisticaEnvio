package com.jc.apiLogistics.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Component
public class InterceptorJwtIOConfig implements WebMvcConfigurer {

    @Value("${jc.jwt.security.enabled:false}")
    private boolean securityEnabled;

    @Autowired
    private InterceptorJwtIO interceptorJwtIO;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(securityEnabled){
            registry.addInterceptor(interceptorJwtIO);
        }
    }
}
