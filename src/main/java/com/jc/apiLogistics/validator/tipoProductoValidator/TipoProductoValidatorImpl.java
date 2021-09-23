package com.jc.apiLogistics.validator.tipoProductoValidator;

import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class TipoProductoValidatorImpl implements TipoProductoValidator {
    @Override
    public void validator(TipoProductoRequest request) throws ApiUnprocessableEntity {

        if(request.getTipoproducto() == null || request.getTipoproducto().isEmpty()){

            this.message("El tipo producto debe ser obligatorio");
        }
    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
