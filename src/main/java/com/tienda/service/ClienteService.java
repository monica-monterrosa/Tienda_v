package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    public List<Cliente> getClientes();
    
    public List<Cliente> getClientesPorApellidos(String apellidos);
    
    public Cliente getCliente(Cliente cliente);
    
    public void save (Cliente cliente);
    
    public void delete (Cliente cliente);
}