package com.tienda.service;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userDetailsService")
public class UsuarioService implements UserDetailsService{
    //Provoca que si el objeto ya está  en memoria no se crea y se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //Busca usuario en tabla  de usuarios
        Usuario usuario= usuarioDao.findByUsername(username);
        
        if (usuario==null){
            throw new UsernameNotFoundException(username);    
        }
        
        //Se cargan los roles que tiene el usuario
        var roles=new ArrayList<GrantedAuthority>();
        
        for (Rol rol: usuario.getRoles()){ //Se recorrelista roles usuario
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se retorna un usuario
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
}