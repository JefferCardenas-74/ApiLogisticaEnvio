package com.jc.apiLogistics.validator.clienteValidator;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Component
public class ClienteValidatorImpl implements ClienteValidator {

    @Override
    public void validator(ClienteRequest request) throws ApiUnprocessableEntity {

        if(request.getIdentificacion() <= 0){
            this.message("La identificacion es oblogatoria.");
        }
        if(request.getNombre() == null || request.getNombre().isEmpty()){
            this.message("El nombre es obligatorio");
        }
        if(request.getNombre().length() < 3){
            this.message("El nombre es muy corto, debe tener como minimo 3 caracteres");
        }

        if(request.getApellido() == null || request.getApellido().isEmpty()){
            this.message("El apellido es obligatorio");
        }
        if(request.getApellido().length() < 3){
            this.message("El apellido es muy corto, debe tener como minimo 3 caracteres");
        }

        if(request.getTelefono() == null || request.getTelefono().isEmpty()){
            this.message("El telefono es obligatorio");
        }
        if(request.getTelefono().length() < 8){
            this.message("El telefono es muy corto, debe tener como minimo 8 caracteres");
        }

        if(request.getEdad() == 0 || request.getEdad() < 0){
            this.message("La edad debe ser mayor a 0");
        }

    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
