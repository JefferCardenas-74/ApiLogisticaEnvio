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
    private int idcliente;

    @JsonProperty("fecha_entrega")
    private String fechaEntrega;

    @JsonProperty("id_destino")
    private int iddestino;

    @JsonProperty("precio")
    private int precio;

    @JsonProperty("id_transporte")
    private int idtransporte;

    @JsonProperty("id_tipoproducto")
    private int idTipoProducto;

    @JsonProperty("cantidad")
    private int cantidad;

}
