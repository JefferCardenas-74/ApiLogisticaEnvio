package com.jc.apiLogistics.validator.authValidator;

import com.jc.apiLogistics.utils.exceptions.ApiUnauthorized;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Component
public class AuthValidator {

    private static final String CLIENT_CREDENTIAL = "client_credentials";

    public void validate(MultiValueMap<String,String> paramMap, String grantTpye) throws ApiUnauthorized {

        if(grantTpye.isEmpty() || !grantTpye.equals(CLIENT_CREDENTIAL)){
            this.message("El campo grant Type es invalido");
        }

        if(Objects.isNull(paramMap) ||
                paramMap.getFirst("client_id").isEmpty() ||
                paramMap.getFirst("client_secret").isEmpty()){

            this.message("client_id y/o client_secrete son invalidos");
        }

    }

    private void message(String message) throws ApiUnauthorized {
        throw new ApiUnauthorized(message);
    }
}
