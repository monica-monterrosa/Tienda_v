package com.tienda.controller;
import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ArticuloService;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
     
    //Provoca que el objeto se cree si no existe o se use el que existe, no hace más de 1 objeto
    //Se conoce como inyección de dependencias
    @Autowired
    private ArticuloService articuloService;
    
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos",articulos);
        return "index";
    }
    
}