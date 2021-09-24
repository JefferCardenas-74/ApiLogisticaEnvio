package com.jc.apiLogistics.validator.destinoValidator;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface DestinoValidator {

    void validator(DestinoRequest request) throws ApiUnprocessableEntity;
}
