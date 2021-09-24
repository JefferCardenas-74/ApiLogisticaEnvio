package com.jc.apiLogistics.repository;

import com.jc.apiLogistics.entities.TipoDestino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Repository
public interface TipoDestinoRepository extends CrudRepository<TipoDestino, Integer> {
}
