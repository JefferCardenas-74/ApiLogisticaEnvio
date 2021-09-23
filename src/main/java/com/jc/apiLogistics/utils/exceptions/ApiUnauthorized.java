package com.jc.apiLogistics.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Exception 401
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{

    public ApiUnauthorized(String message){
        super(message);
    }
}
