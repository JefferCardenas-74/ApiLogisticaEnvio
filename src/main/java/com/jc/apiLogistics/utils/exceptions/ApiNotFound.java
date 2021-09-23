package com.jc.apiLogistics.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Exception 404
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception{

    public ApiNotFound(String message){
        super(message);
    }
}
