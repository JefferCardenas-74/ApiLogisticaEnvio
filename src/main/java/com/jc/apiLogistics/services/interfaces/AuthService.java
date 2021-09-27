package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.dto.JwtResponse;
import com.jc.apiLogistics.security.JwtIO;
import com.jc.apiLogistics.utils.helpers.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Service
public class AuthService{

    @Autowired
    private JwtIO jwtIO;

    @Autowired
    private DateUtil dateUtil;

    @Value("${jc.jwt.token.expires-in}")
    private int EXPIRES_IN;

    public JwtResponse login(String clientId, String clientSecret){

        JwtResponse jwt = JwtResponse.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken("hola mundo desde AuthServices"))
                .issuedAt(dateUtil.getDateMillis() + "")
                .clientId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();

        return jwt;
    }
}
