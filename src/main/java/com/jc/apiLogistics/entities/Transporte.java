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
@Table(name = "transporte")
public class Transporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transporte")
    private int idTransporte;

    @JoinColumn(name = "idTipoTransporte")
    @Column(name = "idtipotransporte")
    private int idtipotransporte;

    @JoinColumn(name = "idTipoIdTransporte")
    @Column(name = "idtipoidtransporte")
    private int idtipoidtransporte;

    @Column(name = "id")
    private String identificacion;

}
