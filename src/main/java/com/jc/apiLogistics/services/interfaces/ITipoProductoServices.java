package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.entities.TipoProducto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Service
public interface ITipoProductoServices {

    void save(TipoProductoRequest tipoProducto);
    List<TipoProducto> findAll();
}
