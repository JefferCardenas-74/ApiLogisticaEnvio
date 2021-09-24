package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.dto.TransporteRequest;
import com.jc.apiLogistics.entities.TipoIdTransporte;
import com.jc.apiLogistics.entities.TipoTransporte;
import com.jc.apiLogistics.entities.Transporte;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface ITransporteServices {

    List<Transporte> listarTransporte();

    List<Transporte> listarTransporteXTipo(int idTipo);

    List<TipoTransporte> listarTipoTransporte();

    List<TipoIdTransporte> listarTipoIdTransporte();

    void save(TransporteRequest request);

}
