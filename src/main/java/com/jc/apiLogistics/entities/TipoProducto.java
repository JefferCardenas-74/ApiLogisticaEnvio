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
@Table(name = "tipoproducto")
public class TipoProducto implements Serializable {

    @Id
    @Column(name = "id_tipoproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipoproducto;

    @Column(name = "tipoproducto")
    private String tipoProducto;

}
