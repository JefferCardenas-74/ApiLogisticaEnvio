package com.jc.apiLogistics.validator.transporteValidator;

import com.jc.apiLogistics.dto.TransporteRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import com.jc.apiLogistics.utils.helpers.ValidarIdTransporte;
import org.springframework.stereotype.Component;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class TransporteValidatorImpl implements TransporteValidator{
    @Override
    public void validator(TransporteRequest request) throws ApiUnprocessableEntity {

        if(request.getIdtipotransporte() <= 0){
            this.message("El tipo de transporte no es valido");
        }

        if(request.getIdtipoidtransporte() <= 0){
            this.message("El tipo ID de transporte no es valido");
        }

       if(request.getIdtipotransporte() == 1){
           if(!ValidarIdTransporte.validarPlaca(request.getIdentificacion())){
               this.message("El ID de transporte no es valido");
           }
       }else if(request.getIdtipotransporte() == 2){
           if(!ValidarIdTransporte.validarNoFlota(request.getIdentificacion())){
               this.message("El ID de transporte no es valido");
           }
        }

       if(request.getIdtipotransporte() != request.getIdtipoidtransporte()){
           this.message("El ID del transporte no coincide con el tipo de transporte");
       }
    }

    private void message(String message) throws ApiUnprocessableEntity {
        throw new ApiUnprocessableEntity(message);
    }
}
