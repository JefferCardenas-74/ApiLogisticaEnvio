package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.entities.Destino;
import com.jc.apiLogistics.repository.DestinoRepository;
import com.jc.apiLogistics.services.interfaces.IDestinoServices;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class DestinoImpl implements IDestinoServices {

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public void save(DestinoRequest destino) {
        Destino destino1 = MMapper.modelMapper().map(destino, Destino.class);
        this.destinoRepository.save(destino1);

    }

    @Override
    public List<Destino> listarPorTipo(String destino) {

        return this.destinoRepository.listarPorTipo(destino);
    }

    @Override
    public List<Destino> listarDestinos() {

        List<Destino> lista = new ArrayList<>();

        Iterable<Destino> listaDestino = this.destinoRepository.findAll();

        for(Object item : listaDestino){
            lista.add(MMapper.modelMapper().map(item, Destino.class));
        }

        return lista;
    }
}
