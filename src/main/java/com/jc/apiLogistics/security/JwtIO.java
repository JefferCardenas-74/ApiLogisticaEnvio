package com.jc.apiLogistics.security;

import com.jc.apiLogistics.utils.helpers.GsonUtils;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import javassist.expr.ExprEditor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class JwtIO {

    @Value("${jc.jwt.token.secret:secret}")
    private String SECRET;
    @Value("${jc.jwt.timezone:UTC}")
    private String TIMEZONE;
    @Value("${jc.jwt.token.expires-in:3600}")
    private int EXPIRES_IN;
    @Value("${jc.jwt.issuer:none}")
    private String ISSUER;

    public String generateToken(Object src){

        String subjet = GsonUtils.serialize(src);

        // construir un HMAC signer usando SHA-256
        Signer signer = HMACSigner.newSHA256Signer(SECRET);

        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);

        /**
         * se obtiene la hora actual y se le agrega el tiempo de la variable EXPIRES_IN (3600) segundos
         * */
        ZonedDateTime zdt = ZonedDateTime.now(tz.toZoneId()).plusSeconds(EXPIRES_IN);

        /**
         * se crea el objecto jwt que posteriormente sera codificado y firmado con la clave secreta
         * */
        JWT jwt = new JWT()
                .setIssuer(ISSUER)
                .setIssuedAt(ZonedDateTime.now(tz.toZoneId()))
                .setSubject(subjet)
                .setExpiration(zdt);

        return JWT.getEncoder().encode(jwt, signer);
    }

    public boolean validateToken(String encodedJWT){

        /**
         * se valida que el token que llega por parametro sea valido
         * y se retorna false si no ha expirado y true si ya expiro
         * */
        JWT jwt = jwt(encodedJWT);
        return jwt.isExpired();
    }

    public String getPayload(String encodedJWT){
        JWT jwt = jwt(encodedJWT);
        return jwt.subject;
    }

    private JWT jwt(String encodeJWT){

        /**
         * con base a la palabra secreta que se uso para encriptar el token,
         * se verifica que este sea valido
         * */
        Verifier verifier = HMACVerifier.newVerifier(SECRET);
        return JWT.getDecoder().decode(encodeJWT, verifier);
    }
}
