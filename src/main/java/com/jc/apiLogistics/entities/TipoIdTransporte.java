package com.jc.apiLogistics.entities;

import lombok.Data;
import org.hibernate.annotations.CollectionId;

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
@Table(name = "tipoidtransporte")
public class TipoIdTransporte implements Serializable {

    @Id
    @Column(name = "id_tipoidtransporte")
    private int idTipoIdTransporte;

    @Column(name = "tipoidtransporte")
    private String tipoIdTransporte;
}
