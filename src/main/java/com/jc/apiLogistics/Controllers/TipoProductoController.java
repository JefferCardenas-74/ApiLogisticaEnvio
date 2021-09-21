package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.services.interfaces.ITipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@RestController
@RequestMapping("/v1/tipoproducto")
public class TipoProductoController {

    @Autowired
    private ITipoProductoServices tipoProductoServices;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTipoProductos(){

        return ResponseEntity.ok(this.tipoProductoServices.findAll());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarTipoProducto(@RequestBody TipoProductoRequest request){

        this.tipoProductoServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
