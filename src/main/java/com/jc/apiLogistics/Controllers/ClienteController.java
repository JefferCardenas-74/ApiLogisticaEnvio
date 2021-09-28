package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.services.interfaces.IClienteServices;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import com.jc.apiLogistics.validator.clienteValidator.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    @Autowired
    private IClienteServices iClienteServices;

    @Autowired
    private ClienteValidator clienteValidator;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarClientes(){

        return ResponseEntity.ok(this.iClienteServices.findAll());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarCliente(@RequestBody ClienteRequest request) throws ApiUnprocessableEntity {

        clienteValidator.validator(request);

        this.iClienteServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }



}
