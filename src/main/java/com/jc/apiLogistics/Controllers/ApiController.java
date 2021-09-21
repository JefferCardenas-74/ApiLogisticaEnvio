package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.services.interfaces.IClienteServices;
import com.jc.apiLogistics.services.interfaces.ITipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/terrestrial")
public class ApiController {


    @Autowired
    private IClienteServices iClienteServices;

    @Autowired
    private ITipoProductoServices tipoProductoServices;

    /*Routes de Cliente*/

    @GetMapping(value = "/all/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarClientes(){

        return ResponseEntity.ok(this.iClienteServices.findAll());
    }

    @PostMapping(value = "/save/cliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarCliente(@RequestBody ClienteRequest request){

        this.iClienteServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    /*************************************************************************/

    /*Routes de Tipo Producto*/

    @GetMapping(value = "/all/tipoproductos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTipoProductos(){

        return ResponseEntity.ok(this.tipoProductoServices.findAll());
    }

    @PostMapping(value = "/save/tipoproducto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarTipoProducto(@RequestBody TipoProductoRequest request){

        this.tipoProductoServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
    /*************************************************************************/
}
