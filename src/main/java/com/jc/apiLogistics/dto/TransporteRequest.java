package com.jc.apiLogistics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Data
public class TransporteRequest implements Serializable {

    @JsonProperty("id_tipoTransporte")
    private int idtipotransporte;

    @JsonProperty("id_tipoidtransporte")
    private int idtipoidtransporte;

    @JsonProperty("id")
    private String identificacion;
}
