package com.jc.apiLogistics.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class InterceptorJwtIO implements HandlerInterceptor {

    @Value("${jc.jwt.token.auth.path}")
    private String AUTH_PATH;

    @Value("#{'${jc.jwt.excluded.path}'.split(',')}")
    private List<String> excluded;

    @Autowired
    private JwtIO jwtIO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean validate = false;
        String uri = request.getRequestURI();

        if(uri.equals(AUTH_PATH) || excluded(uri)){
            validate = true;
        }

        if(!validate && request.getHeader("Authorization") != null && !request.getHeader("Authorization").isEmpty()){
            String token = request.getHeader("Authorization").replace("Bearer", "");

            validate = !this.jwtIO.validateToken(token);
        }

        if(!validate){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

        return true;
    }

    private boolean excluded(String path){
        boolean result = false;

        for(String item : excluded){
            if(!item.equals("#") && item.equals(path)){
                result = true;
            }
        }
        return result;
    }
}
