package com.jc.apiLogistics.repository;

import com.jc.apiLogistics.entities.Transporte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Repository
public interface TransporteRepository extends CrudRepository<Transporte, Integer> {

    /**
     *  funcion para filtrar los transportes por tipo (Camion, Barco)
     * */
    @Transactional
    List<Transporte> findByIdtipotransporte(int idTipo);

    @Transactional
    Transporte findByIdTransporte(int idTransporte);
}
