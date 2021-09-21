package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.TipoProductoRequest;
import com.jc.apiLogistics.entities.TipoProducto;
import com.jc.apiLogistics.repository.TipoProductoRepository;
import com.jc.apiLogistics.services.interfaces.ITipoProductoServices;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Component
public class TipoProductoImpl implements ITipoProductoServices {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Override
    public void save(TipoProductoRequest tipoProducto) {

        TipoProducto producto = MMapper.modelMapper().map(tipoProducto, TipoProducto.class);

        this.tipoProductoRepository.save(producto);

    }

    @Override
    public List<TipoProducto> findAll() {

        List<TipoProducto> productos = new ArrayList<>();

        Iterable<TipoProducto> productos1 = this.tipoProductoRepository.findAll();

        for(TipoProducto item : productos1){

            productos.add(item);
        }

        return productos;
    }
}
