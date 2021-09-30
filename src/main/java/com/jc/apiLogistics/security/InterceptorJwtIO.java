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

        /**
         * se valida que la requestURI sea igual a la ruta para solicitar el token, o que la ruta pertenezca
         * a las rutas excluidas, esto con el fin de permitir el paso sin necesidad de un token
         * */
        if(uri.equals(this.AUTH_PATH) || excluded(uri)){

            validate = true;
        }

        /**
         * se valida que en el header de la peticion venga el token, para validar su valides
         * si el token ya expiro se retornara false y se impedira el paso, de lo contrario se retornara true
         * */
        if(!validate && request.getHeader("Authorization") != null && !request.getHeader("Authorization").isEmpty()){

            String token = request.getHeader("Authorization").replace("Bearer ", "");
            validate = !jwtIO.validateToken(token);
        }

        if(!validate){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

        return validate;
    }

    private boolean excluded(String path){
        boolean result = false;

        /**
         * se valida si alguna de las rutas que hay en la lista de rutas excluidas es igual a la ruta que tiene la peticion actual
         * si es asi, se retorna true para permitir el acceso sin la necesidad de un token
         * */
        for(String item : this.excluded){
            if(!item.equals("#") && item.equals(path)){
                result = true;
            }
        }
        return result;
    }
}
