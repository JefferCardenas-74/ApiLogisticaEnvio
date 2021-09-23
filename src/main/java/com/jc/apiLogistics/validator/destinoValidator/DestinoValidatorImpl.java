package com.jc.apiLogistics.validator.destinoValidator;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class DestinoValidatorImpl implements DestinoValidator{
    @Override
    public void validator(DestinoRequest request) throws ApiUnprocessableEntity {

        if(request.getTipodestino().getId_tipodestino() <= 0){
            this.message("Debe espicificar el id del destino");
        }

        if(request.getCiudad() == null || request.getCiudad().isEmpty()){
            this.message("La ciudad debe ser obligatoria");
        }
        
        if(request.getDireccion() == null || request.getDireccion().isEmpty()){
            this.message("La direccion el obligatoria");
        }
    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
