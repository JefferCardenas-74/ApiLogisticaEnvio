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
@Table(name = "tipoproducto")
public class TipoProducto implements Serializable {

    @Id
    @Column(name = "idTipoProducto")
    private int idTipoProducto;

    @Column(name = "tipoProducto")
    private String tipoProducto;

}
