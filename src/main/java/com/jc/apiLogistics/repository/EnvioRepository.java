package com.jc.apiLogistics.repository;

import com.jc.apiLogistics.entities.Envio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Repository
public interface EnvioRepository extends CrudRepository<Envio, Integer> {

    /**
     * funcion para filtrar los envios hacia un respectivo destino
     * */
    @Transactional
    List<Envio> findByIddestino(int idDestino);

    /**
     * funcion para filtrar los envios realizados por un respectivo cliente
     * */
    @Transactional
    List<Envio> findByIdcliente(int idCliente);

    @Transactional
    Envio findByGuia(String guia);

}
