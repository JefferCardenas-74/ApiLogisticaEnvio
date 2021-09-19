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
@Table(name = "tipoproductoenvio")
public class TipoProductoEnvio implements Serializable {

    @Id
    @Column(name = "idTipoProductoEnvio")
    private int idTipoProductoEnvio;

    @Column(name = "idTipoProducto")
    private int idTipoProducto;

    @Column(name = "idEnvio")
    private int idEnvio;

    @Column(name = "cantidad")
    private int cantidad;


}
