package com.jc.apiLogistics.validator.envioValidator;

import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.entities.Envio;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface EnvioValidator {

    void validator(EnvioRequest request) throws ApiUnprocessableEntity, ParseException;
}
