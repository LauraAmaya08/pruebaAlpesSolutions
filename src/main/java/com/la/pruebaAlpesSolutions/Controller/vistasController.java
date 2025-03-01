package com.la.pruebaAlpesSolutions.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarea")
public class vistasController {

    @GetMapping("/listar")
    public String inicio (){
        return "tarea";
    }

    @GetMapping("/crear")
    public String crear (){
        return "crear";
    }
}
