package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.services.interfaces.IClienteServices;
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

    @GetMapping(value = "/all")
    public ResponseEntity<Object> index(){

        return ResponseEntity.ok("SI SE CONECTO CRACK...!");
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarCliente(@RequestBody ClienteRequest request){

        this.iClienteServices.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
