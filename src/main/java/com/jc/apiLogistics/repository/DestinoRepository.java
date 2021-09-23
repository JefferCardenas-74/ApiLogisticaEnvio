package com.jc.apiLogistics.repository;

import com.jc.apiLogistics.entities.Destino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Repository
public interface DestinoRepository extends CrudRepository<Destino, Integer> {

    @Query(
            value = "select id_destino, ciudad, direccion, tipodestino.destino from destino inner join tipodestino on destino.id_tipodestino = tipodestino.id_tipodestino where tipodestino.destino = :destino",
            nativeQuery = true
    )
    List<Destino> listarPorTipo(@Param("destino") String destino);

}
