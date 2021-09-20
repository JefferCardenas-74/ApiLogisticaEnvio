package com.jc.apiLogistics.services.interfaces;

import com.jc.apiLogistics.dto.ClienteRequest;
import com.jc.apiLogistics.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */

@Service
public interface IClienteServices {

    void save(ClienteRequest cliente);
    List<Cliente> findAll();
}
