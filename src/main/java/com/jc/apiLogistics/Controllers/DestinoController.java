package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.entities.Destino;
import com.jc.apiLogistics.services.interfaces.IDestinoServices;
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

    @GetMapping(value = "/all/{destino}",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> listarDestinoPorTipo(@PathVariable("destino") String destino){

        return ResponseEntity.ok(this.destinoServices.listarPorTipo(destino));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> guardarDestino(@RequestBody DestinoRequest request){

        this.destinoServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
