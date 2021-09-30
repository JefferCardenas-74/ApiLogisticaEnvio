package com.jc.apiLogistics.repository;

import com.jc.apiLogistics.entities.Destino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Repository
public interface DestinoRepository extends CrudRepository<Destino, Integer> {

    List<Destino> findByIdtipodestino(int idTipoDestino);

    Destino findByIddestino(int idDestino);
}
