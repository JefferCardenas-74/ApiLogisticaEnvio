package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.entities.Destino;
import com.jc.apiLogistics.repository.DestinoRepository;
import com.jc.apiLogistics.services.interfaces.IDestinoServices;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        List<Destino> lista = new ArrayList<>();

        List<Destino> listaDestino = this.destinoRepository.listarPorTipo(destino);

        lista.addAll(listaDestino);

        return lista;
    }
}
