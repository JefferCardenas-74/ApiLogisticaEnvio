package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.entities.Envio;
import com.jc.apiLogistics.repository.EnvioRepository;
import com.jc.apiLogistics.services.interfaces.IEnvioServices;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.MemoryManagerMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class EnvioImpl implements IEnvioServices {

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public void save(EnvioRequest request) {
        Envio envio = MMapper.modelMapper().map(request, Envio.class);

        this.envioRepository.save(envio);
    }

    @Override
    public List<Envio> findAll() {

        List<Envio> listaEnvio = new ArrayList<>();
        Iterable<Envio> lista = this.envioRepository.findAll();

        for(Object item : lista){
            listaEnvio.add(MMapper.modelMapper().map(item, Envio.class));
        }
        return listaEnvio;
    }
}
