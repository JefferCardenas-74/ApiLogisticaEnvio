package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.services.interfaces.IEnvioServices;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import com.jc.apiLogistics.validator.envioValidator.EnvioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/envio")
public class EnvioController {

    @Autowired
    private IEnvioServices envioServices;

    @Autowired
    private EnvioValidator envioValidator;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarEnvios(){

        return ResponseEntity.ok(this.envioServices.findAll());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarEnvios(@RequestBody EnvioRequest request) throws ParseException, ApiUnprocessableEntity {

        this.envioValidator.validator(request);
        this.envioServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/all/destino/{idDestino}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarEnviosXDestino(@PathVariable("idDestino") int destino){

        return ResponseEntity.ok(this.envioServices.findByIddestino(destino));
    }

    @GetMapping(value = "/all/cliente/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarEnviosXCliente(@PathVariable("idCliente") int cliente){

        return ResponseEntity.ok(this.envioServices.findByIdcliente(cliente));
    }

}
