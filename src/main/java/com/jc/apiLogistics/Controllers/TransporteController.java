package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.TransporteRequest;
import com.jc.apiLogistics.entities.Transporte;
import com.jc.apiLogistics.services.interfaces.ITransporteServices;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import com.jc.apiLogistics.validator.transporteValidator.TransporteValidator;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@RestController
@RequestMapping("/v1/transporte")
public class TransporteController {

    @Autowired
    private ITransporteServices transporteServices;

    @Autowired
    private TransporteValidator transporteValidator;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTransportes(){

        return ResponseEntity.ok(this.transporteServices.listarTransporte());
    }

    @GetMapping(value = "/all/{idTipo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTransporteXTipo(@PathVariable("idTipo") int idTipo){

        return ResponseEntity.ok(this.transporteServices.listarTransporteXTipo(idTipo));
    }

    @GetMapping(value = "/all/tipo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTiposTransportes(){

        return ResponseEntity.ok(this.transporteServices.listarTipoTransporte());
    }

    @GetMapping(value = "/all/tipoId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTipoIdTransportes(){

        return ResponseEntity.ok(this.transporteServices.listarTipoIdTransporte());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarTransporte(@RequestBody TransporteRequest request) throws ApiUnprocessableEntity {

        this.transporteValidator.validator(request);

        this.transporteServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
