package com.jc.apiLogistics.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipodestino")
    private int id_tipodestino;

    @Column(name = "destino")
    private String destino;

//    @OneToMany(targetEntity = Destino.class)
//    private List<Destino> destinos = new ArrayList<>();

}
