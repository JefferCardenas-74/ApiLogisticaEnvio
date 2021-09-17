package com.jc.apiLogistics.Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/terrestrial")
public class ApiController {

    @GetMapping(value = "/all")
    private ResponseEntity<Object> index(){

        return ResponseEntity.ok("SI SE CONECTO CRACK...!");
    }
}
