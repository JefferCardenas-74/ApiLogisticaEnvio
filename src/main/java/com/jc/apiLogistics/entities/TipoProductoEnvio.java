package com.jc.apiLogistics.entities;

import lombok.Data;

import javax.persistence.*;
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
    @Column(name = "id_tipoproductoenvio")
    private int idTipoProductoEnvio;

    @JoinColumn(name = "idtipoproducto")
    @Column(name = "id_tipoproducto")
    private int idTipoProducto;

    @JoinColumn(name = "idEnvio")
    @Column(name = "id_envio")
    private int idEnvio;

    @Column(name = "cantidad")
    private int cantidad;

}
