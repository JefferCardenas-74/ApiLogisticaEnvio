package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.entities.TipoDestino;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface ITipoDestinoServices {

    List<TipoDestino> listaTipoDestinos();
}
