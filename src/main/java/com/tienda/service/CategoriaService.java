package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save (Categoria categoria);
    
    public void delete (Categoria categoria);
}