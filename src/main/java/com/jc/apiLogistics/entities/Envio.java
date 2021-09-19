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
    @Column(name = "idEnvio")
    private int idEnvio;

    @Column(name = "idCliente")
    private int idCliente;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Column(name = "fechaEntrega")
    private Date fechaEntrega;

    @Column(name = "idDestino")
    private int idDestino;

    @Column(name = "precio")
    private int precio;

    @Column(name = "guia")
    private String guia;

    @Column(name = "idTransporte")
    private int idTransporte;

}
