package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.entities.Envio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface IEnvioServices {

    void save(EnvioRequest request);

    List<Envio> findAll();
}
