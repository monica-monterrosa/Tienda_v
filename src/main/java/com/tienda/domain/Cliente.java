
package com.tienda.domain;

import lombok.Data;

@Data
public class Cliente {
   
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    
public Cliente(String nombre, String apellidos, String correo, String telefono){
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.correo = correo;
    this.telefono = telefono;
}    
}

