package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.entities.TipoDestino;
import com.jc.apiLogistics.repository.TipoDestinoRepository;
import com.jc.apiLogistics.services.interfaces.ITipoDestinoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class TipoDestinoImpl implements ITipoDestinoServices {

    @Autowired
    private TipoDestinoRepository tipoDestinoRepository;

    @Override
    public List<TipoDestino> listaTipoDestinos() {

        Iterable<TipoDestino> lista = this.tipoDestinoRepository.findAll();

        return new ArrayList<>((Collection<? extends TipoDestino>) lista);
    }
}
