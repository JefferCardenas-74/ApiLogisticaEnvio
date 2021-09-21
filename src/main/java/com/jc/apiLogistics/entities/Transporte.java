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
@Table(name = "transporte")
public class Transporte implements Serializable {

    @Id
    @Column(name = "id_transporte")
    private int idTransporte;

    @Column(name = "id_tipotransporte")
    private int idTipoTransporte;

    @Column(name = "id_tipotdtransporte")
    private int idTipoIdTransporte;

    @Column(name = "id")
    private int id;

}
