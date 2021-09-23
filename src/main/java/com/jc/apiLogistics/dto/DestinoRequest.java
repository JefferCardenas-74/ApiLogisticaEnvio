package com.jc.apiLogistics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jc.apiLogistics.entities.TipoDestino;
import lombok.Data;

import java.awt.*;
import java.io.Serializable;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Data
public class DestinoRequest implements Serializable {

    @JsonProperty("id_tipodestino")
    private TipoDestino tipodestino;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("direccion")
    private String direccion;
}
