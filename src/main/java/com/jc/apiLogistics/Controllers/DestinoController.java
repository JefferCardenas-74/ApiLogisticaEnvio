package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.entities.Destino;
import com.jc.apiLogistics.services.interfaces.IDestinoServices;
import com.jc.apiLogistics.services.interfaces.ITipoDestinoServices;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import com.jc.apiLogistics.validator.destinoValidator.DestinoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@RestController
@RequestMapping("/v1/destino")
public class DestinoController {

    @Autowired
    private IDestinoServices destinoServices;

    @Autowired
    private DestinoValidator destinoValidator;

    @Autowired
    private ITipoDestinoServices tipoDestinoServices;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarDestinos(){

        return ResponseEntity.ok(this.destinoServices.listarDestinos());
    }

    @GetMapping(value = "/all/{destino}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarDestinoPorTipo(@PathVariable("destino") int destino){

        return ResponseEntity.ok(this.destinoServices.listarPorTipo(destino));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarDestino(@RequestBody DestinoRequest request) throws ApiUnprocessableEntity {

        destinoValidator.validator(request);

        this.destinoServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/all/tipoDestino", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTipoDestinos(){
        return ResponseEntity.ok(this.tipoDestinoServices.listaTipoDestinos());
    }
}
