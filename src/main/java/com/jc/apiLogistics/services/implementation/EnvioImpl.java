package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.EnvioDTO;
import com.jc.apiLogistics.dto.EnvioRequest;
import com.jc.apiLogistics.entities.Destino;
import com.jc.apiLogistics.entities.Envio;
import com.jc.apiLogistics.entities.TipoProductoEnvio;
import com.jc.apiLogistics.repository.DestinoRepository;
import com.jc.apiLogistics.repository.EnvioRepository;
import com.jc.apiLogistics.repository.TipoProductoEnvioRepository;
import com.jc.apiLogistics.services.interfaces.IEnvioServices;
import com.jc.apiLogistics.utils.helpers.DateUtil;
import com.jc.apiLogistics.utils.helpers.GeneradorGuia;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.MemoryManagerMXBean;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class EnvioImpl implements IEnvioServices {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private TipoProductoEnvioRepository tipoProductoEnvioRepository;

    @Autowired
    private DestinoRepository destinoRepository;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public void save(EnvioRequest request) throws ParseException {

        EnvioDTO envioDTO = MMapper.modelMapper().map(request, EnvioDTO.class);

        Envio envio = MMapper.modelMapper().map(envioDTO, Envio.class);
        envio.setFechaRegistro(dateUtil.fechaActual());
        envio.setFechaEntrega(dateUtil.getDate(request.getFechaEntrega()));
        /* Genera una String alfanumerico de 10 digitos de manera aleatoria */
        envio.setGuia(GeneradorGuia.generadorGuia());

        /* se obitne el destino con el fin de saber que tipo de destino (bodega o puerto) es para asi mismo asginar el descuento */
        Destino destino = this.destinoRepository.findByIddestino(envioDTO.getIddestino());

        /* se valida si es puerto o bodega para asi mismo asignar el debido descuento */
        /**
         *  1 indica que bodega (Logistica terrestre)
         *  2 indica que es puerto (Logistica maritima)
         * */
        if(envioDTO.getCantidad() > 10 && destino.getIdtipodestino() == 1){

            int precio = envioDTO.getPrecio();
            int descuento = (int)(precio * 0.05);
            envio.setDescuento(descuento);

        }else if(envioDTO.getCantidad() > 10 && destino.getIdtipodestino() == 2){

            int precio = envioDTO.getPrecio();
            int descuento = (int)(precio * 0.03);
            envio.setDescuento(descuento);

        }else{
            envio.setDescuento(0);
        }

        String guia = envio.getGuia();

        this.envioRepository.save(envio);

        /* con base a la guia se obtiene el registro que acabamos de hacer para obtener su id y poder hacer el insert a la tabla pivote TipoProductoEnvio*/
        Envio nuevoEnvio = this.envioRepository.findByGuia(guia);

        TipoProductoEnvio tipoProductoEnvio = new TipoProductoEnvio();
        tipoProductoEnvio.setIdEnvio(nuevoEnvio.getIdEnvio());
        tipoProductoEnvio.setIdTipoProducto(envioDTO.getIdtipoproducto());
        tipoProductoEnvio.setCantidad(envioDTO.getCantidad());

        this.tipoProductoEnvioRepository.save(tipoProductoEnvio);
    }

    @Override
    public List<Envio> findAll() {

        List<Envio> listaEnvio = new ArrayList<>();
        Iterable<Envio> lista = this.envioRepository.findAll();

        for(Object item : lista){
            listaEnvio.add(MMapper.modelMapper().map(item, Envio.class));
        }
        return listaEnvio;
    }

    @Override
    public List<Envio> findByIddestino(int destino) {
        List<Envio> listaXdestino = new ArrayList<>();
        Iterable<Envio>  lista = this.envioRepository.findByIddestino(destino);

        for(Object item : lista){
            listaXdestino.add(MMapper.modelMapper().map(item, Envio.class));
        }

        return listaXdestino;
    }

    @Override
    public List<Envio> findByIdcliente(int cliente) {

        List<Envio> listaXcliente = new ArrayList<>();

        Iterable<Envio> lista = this.envioRepository.findByIdcliente(cliente);

        for(Object item : lista){
            listaXcliente.add(MMapper.modelMapper().map(item, Envio.class));
        }

        return listaXcliente;
    }
}
