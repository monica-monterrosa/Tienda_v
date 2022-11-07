package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaServiceImpl implements CategoriaService{
    //Provoca que si el objeto ya está  en memoria no se crea y se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private CategoriaDao categoriaDao;
    
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean filtro){
        var lista=(List<Categoria>)categoriaDao.findAll();
        
        //Solo activas retornan
        if (filtro){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
    return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save (Categoria categoria){
        categoriaDao.save(categoria);
    }
    
    @Override
    @Transactional
    public void delete (Categoria categoria){
        categoriaDao.delete(categoria);
    }
}