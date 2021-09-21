package com.jc.apiLogistics.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Data
@Entity
@Table(name = "tipodestino")
public class TipoDestino implements Serializable {

    @Id
    @Column(name = "id_tipodestino")
    private int id_tipodestino;

    @Column(name = "destino")
    private String destino;


}
