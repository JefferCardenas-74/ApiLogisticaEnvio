package com.jc.apiLogistics.validator.transporteValidator;

import com.jc.apiLogistics.dto.TransporteRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface TransporteValidator {

    void validator(TransporteRequest request) throws ApiUnprocessableEntity;
}
