package com.jc.apiLogistics.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Exception 422
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception{

    public ApiUnprocessableEntity(String message){
        super(message);
    }

}
