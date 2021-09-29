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

    @Transactional
    List<Envio> findByIddestino(int idDestino);

//    @Query(
//            value = "select tipoproducto.tipoproducto, tipoproductoenvio.cantidad, envio.fecharegistro, envio.fechaentrega, destino.ciudad, envio.precio, transporte.id, envio.guia from envio inner join transporte \n" +
//                    "on envio.id_transporte = transporte.id_transporte inner join destino \n" +
//                    "on envio.id_destino = destino.id_destino inner join cliente \n" +
//                    "on envio.id_cliente = cliente.id_cliente inner join tipoproductoenvio\n" +
//                    "on envio.id_envio = tipoproductoenvio.id_envio inner join tipoproducto\n" +
//                    "on tipoproductoenvio.id_tipoproducto = tipoproducto.id_tipoproducto\n" +
//                    "where transporte.id_transporte = :param",
//            nativeQuery = true
//    )
//    List<Envio> findByIddestino( int idDestino);

    @Transactional
    List<Envio> findByIdcliente(int idCliente);

    @Transactional
    Envio findByGuia(String guia);
}
