package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save (Articulo articulo);
    
    public void delete (Articulo articulo);
}