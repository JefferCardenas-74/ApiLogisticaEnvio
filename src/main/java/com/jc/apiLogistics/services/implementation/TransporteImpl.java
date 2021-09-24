package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.TransporteRequest;
import com.jc.apiLogistics.entities.TipoIdTransporte;
import com.jc.apiLogistics.entities.TipoTransporte;
import com.jc.apiLogistics.entities.Transporte;
import com.jc.apiLogistics.repository.TipoIdTransporteRepository;
import com.jc.apiLogistics.repository.TipoTransporteRespository;
import com.jc.apiLogistics.repository.TransporteRepository;
import com.jc.apiLogistics.services.interfaces.ITransporteServices;
import com.jc.apiLogistics.utils.helpers.MMapper;
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
public class TransporteImpl implements ITransporteServices {

    @Autowired
    private TransporteRepository transporteRepository;

    @Autowired
    private TipoTransporteRespository tipoTransporteRespository;

    @Autowired
    private TipoIdTransporteRepository tipoIdTransporteRepository;

    @Override
    public List<Transporte> listarTransporte() {

        Iterable<Transporte> lista = this.transporteRepository.findAll();

        return new ArrayList<>((Collection<? extends Transporte>) lista);
    }

    @Override
    public List<Transporte> listarTransporteXTipo(int idTipo) {

        Iterable<Transporte> lista = this.transporteRepository.findByIdtipotransporte(idTipo);

        return new ArrayList<>((Collection<? extends Transporte>) lista);
    }

    @Override
    public List<TipoTransporte> listarTipoTransporte() {

        Iterable<TipoTransporte> lista = this.tipoTransporteRespository.findAll();

        return new ArrayList<>((Collection<? extends TipoTransporte>) lista);
    }

    @Override
    public List<TipoIdTransporte> listarTipoIdTransporte() {

        Iterable<TipoIdTransporte> lista = this.tipoIdTransporteRepository.findAll();

        return new ArrayList<>((Collection<? extends TipoIdTransporte>) lista);
    }

    @Override
    public void save(TransporteRequest request) {

        Transporte tmp = MMapper.modelMapper().map(request, Transporte.class);

        this.transporteRepository.save(tmp);
    }
}
