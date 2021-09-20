package com.jc.apiLogistics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Data
public class ClienteRequest implements Serializable {

    @JsonProperty("identificacion")
    private int identificacion;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("edad")
    private int edad;
}
