package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.dto.DestinoRequest;
import com.jc.apiLogistics.entities.Destino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Service
public interface IDestinoServices {

    void save(DestinoRequest destino);

    List<Destino> listarPorTipo( String destino);
}
