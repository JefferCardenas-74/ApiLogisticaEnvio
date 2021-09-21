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
@Table(name = "destino")
public class Destino implements Serializable {

    @Id
    @Column(name = "id_destino")
    private int idDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipodestino")
    private TipoDestino id_tipodestino;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;
}
