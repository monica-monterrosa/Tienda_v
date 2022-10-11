package com.tienda.controller;

import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String inicio(Model model){
        var texto="Estamos en semana 4";
        model.addAttribute("saludo",texto);
        
        Cliente cliente1=new Cliente("Pedro","Jimenez Retana", "pjimenez@gmail.com","8989-9898");
        
        Cliente cliente2=new Cliente("Juan","Retana Jimenez", "jretana@gmail.com","9898-8989");
        
        Cliente cliente3=new Cliente("Juancho","Retana Jimenez", "jretana@gmail.com","9898-8989");
        
        var clientes=Arrays.asList(cliente1, cliente2,cliente3);
        
        model.addAttribute("clientes",clientes);
        return "index";
    }
    
}