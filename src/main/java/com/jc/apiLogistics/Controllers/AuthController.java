package com.jc.apiLogistics.Controllers;

import com.jc.apiLogistics.services.interfaces.AuthService;
import com.jc.apiLogistics.utils.exceptions.ApiUnauthorized;
import com.jc.apiLogistics.validator.authValidator.AuthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthValidator authValidator;

    @PostMapping(path = "oauth/client_credential/accesstoken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody MultiValueMap<String, String> paramMap, @RequestParam("grant_type") String grantType) throws ApiUnauthorized {

        this.authValidator.validate(paramMap, grantType);

        return ResponseEntity.ok(this.authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret")));
    }
}
