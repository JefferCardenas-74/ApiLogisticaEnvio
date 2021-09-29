package com.jc.apiLogistics.entities;

import lombok.Data;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;

    @JoinColumn(name = "idCliente")
    @Column(name = "id_cliente")
    private int idcliente;

    @Column(name = "fecharegistro")
    private Date fechaRegistro;

    @Column(name = "fechaentrega")
    private Date fechaEntrega;

    @JoinColumn(name = "idDestino")
    @Column(name = "id_destino")
    private int iddestino;

    @Column(name = "precio")
    private int precio;

    @Column(name = "guia")
    private String guia;

    @JoinColumn(name = "idTransporte")
    @Column(name = "id_transporte")
    private int id_transporte;

    private int idTipoProducto;

    private int cantidad;

}
