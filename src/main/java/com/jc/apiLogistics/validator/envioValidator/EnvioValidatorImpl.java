package com.jc.apiLogistics.validator.envioValidator;

import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import com.jc.apiLogistics.utils.helpers.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class EnvioValidatorImpl implements EnvioValidator{

    @Autowired
    private DateUtil dateUtil;

    @Override
    public void validator(EnvioRequest request) throws ApiUnprocessableEntity, ParseException {

        if(request.getIdcliente() <= 0){
            this.message("Debe ingresar un ID de cliente valido.");
        }

        if(request.getFechaEntrega().isEmpty() || request.getFechaEntrega() == null){
            this.message("Debe ingresar la fecha de entrega");
        }

        if(!dateUtil.esMayor(request.getFechaEntrega())){
            this.message("La fecha de entrega debe ser mayor a la actual.");
        }

        if(request.getIddestino() <= 0){
            this.message("Debe ingresar un ID de destino valido");
        }

        if(request.getPrecio() < 0){
            this.message("El precio debe ser un valor entero positivo");
        }

        if(request.getIdtransporte() <= 0){
            this.message("Debe ingresar un ID de transporte valido");
        }

        if(!dateUtil.validarFecha(request.getFechaEntrega())){
            this.message("Debe ingresar una fecha valida");
        }

    }

    private void message(String message) throws ApiUnprocessableEntity {
        throw new ApiUnprocessableEntity(message);
    }
}
