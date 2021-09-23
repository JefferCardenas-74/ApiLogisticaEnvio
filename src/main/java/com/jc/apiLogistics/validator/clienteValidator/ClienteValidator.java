package com.jc.apiLogistics.validator.clienteValidator;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

/**
 *  Interface para la validacion de datos resibidos para la creacion de cliente
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Service
public interface ClienteValidator {

    void validator(ClienteRequest request) throws ApiUnprocessableEntity;
}
