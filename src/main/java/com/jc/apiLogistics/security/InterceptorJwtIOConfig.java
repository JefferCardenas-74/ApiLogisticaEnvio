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
        /**
         * se valida el estado de la variable security alojada en el archivo de application.properties
         * si el estado es true quiere decir que el servicio tendra en cuenta la validacion de un token,
         * de lo contrario se podra hacer uso del servicio sin la necesidad de uno
         * */
        if(securityEnabled){
            registry.addInterceptor(interceptorJwtIO);
        }
    }
}
