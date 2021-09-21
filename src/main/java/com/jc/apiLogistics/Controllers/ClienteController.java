package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.services.interfaces.IClienteServices;
import com.jc.apiLogistics.services.interfaces.IDestinoServices;
import com.jc.apiLogistics.services.interfaces.ITipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.IDN;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {


    @Autowired
    private IClienteServices iClienteServices;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarClientes(){

        return ResponseEntity.ok(this.iClienteServices.findAll());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarCliente(@RequestBody ClienteRequest request){

        this.iClienteServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }



}
