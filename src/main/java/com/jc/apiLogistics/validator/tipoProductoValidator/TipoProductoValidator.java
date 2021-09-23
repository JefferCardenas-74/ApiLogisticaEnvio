package com.jc.apiLogistics.validator.tipoProductoValidator;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

@Service
public interface TipoProductoValidator {

    void validator(TipoProductoRequest request) throws ApiUnprocessableEntity;
}
