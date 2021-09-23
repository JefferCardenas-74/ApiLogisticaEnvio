package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.services.interfaces.IEnvioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/envio")
public class EnvioController {

    @Autowired
    private IEnvioServices envioServices;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> listarEnvios(){

        return ResponseEntity.ok(this.envioServices.findAll());
    }
}
