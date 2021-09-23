package com.jc.apiLogistics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Data
public class EnvioRequest implements Serializable {

    @JsonProperty("id_cliente")
    private int idCliente;

    @JsonProperty("fecha_registro")
    private Date fechaRegistro;

    @JsonProperty("fecha_entrega")
    private Date fechaEntrega;

    @JsonProperty("id_destino")
    private Date idDestino;

    @JsonProperty("precio")
    private int precio;

    @JsonProperty("id_transporte")
    private int idTransporte;


}
