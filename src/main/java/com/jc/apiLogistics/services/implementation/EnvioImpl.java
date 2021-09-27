package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.entities.Envio;
import com.jc.apiLogistics.repository.EnvioRepository;
import com.jc.apiLogistics.services.interfaces.IEnvioServices;
import com.jc.apiLogistics.utils.helpers.DateUtil;
import com.jc.apiLogistics.utils.helpers.GeneradorGuia;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.MemoryManagerMXBean;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class EnvioImpl implements IEnvioServices {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public void save(EnvioRequest request) throws ParseException {

        Envio envio = MMapper.modelMapper().map(request, Envio.class);

        envio.setFechaRegistro(dateUtil.fechaActual());

        envio.setFechaEntrega(dateUtil.getDate(request.getFechaEntrega()));
        /* Genera una String alfanumerico de 10 digitos de manera aleatoria */
        envio.setGuia(GeneradorGuia.generadorGuia());

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

    @Override
    public List<Envio> findByIddestino(int destino) {
        List<Envio> listaXdestino = new ArrayList<>();
        Iterable<Envio>  lista = this.envioRepository.findByIddestino(destino);

        for(Object item : lista){
            listaXdestino.add(MMapper.modelMapper().map(item, Envio.class));
        }

        return listaXdestino;
    }

    @Override
    public List<Envio> findByIdcliente(int cliente) {

        List<Envio> listaXcliente = new ArrayList<>();

        Iterable<Envio> lista = this.envioRepository.findByIdcliente(cliente);

        for(Object item : lista){
            listaXcliente.add(MMapper.modelMapper().map(item, Envio.class));
        }

        return listaXcliente;
    }
}
