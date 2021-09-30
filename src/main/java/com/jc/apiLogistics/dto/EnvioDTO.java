package com.jc.apiLogistics.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Data
public class EnvioDTO implements Serializable {

    private int idEnvio;
    private int idcliente;
    private Date fechaRegistro;
    private Date fechaEntrega;
    private int iddestino;
    private int precio;
    private String guia;
    private int idtransporte;
    private int idtipoproducto;
    private int cantidad;

}
