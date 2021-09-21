package com.jc.apiLogistics.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Data
@Entity
@Table(name = "envio")
public class Envio implements Serializable {

    @Id
    @Column(name = "id_envio")
    private int idEnvio;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "fecharegistro")
    private Date fechaRegistro;

    @Column(name = "fechaentrega")
    private Date fechaEntrega;

    @Column(name = "id_destino")
    private int idDestino;

    @Column(name = "precio")
    private int precio;

    @Column(name = "guia")
    private String guia;

    @Column(name = "id_transporte")
    private int idTransporte;

}
