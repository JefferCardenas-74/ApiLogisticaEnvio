package com.jc.apiLogistics.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Data
@Entity
@Table(name = "destino")
public class Destino implements Serializable {

    @Id
    @Column(name = "idDestino")
    private int idDestino;

    @Column(name = "idTipoDestino")
    private int idTipoDestino;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;
}
