package com.jc.apiLogistics.services.implementation;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.entities.Cliente;
import com.jc.apiLogistics.repository.ClienteRepository;
import com.jc.apiLogistics.services.interfaces.IClienteServices;
import com.jc.apiLogistics.utils.helpers.MMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class ClienteImpl implements IClienteServices {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void save(ClienteRequest cliente) {

        Cliente cliente1 = MMapper.modelMapper().map(cliente, Cliente.class);

        this.clienteRepository.save(cliente1);

    }

    @Override
    public List<Cliente> findAll() {
        return null;
    }
}
