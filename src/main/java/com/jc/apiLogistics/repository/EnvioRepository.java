package com.jc.apiLogistics.repository;

import com.jc.apiLogistics.entities.Envio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Repository
public interface EnvioRepository extends CrudRepository<Envio, Integer> {
}
