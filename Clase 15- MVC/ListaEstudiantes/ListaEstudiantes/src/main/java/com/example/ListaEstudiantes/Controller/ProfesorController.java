package com.example.ListaEstudiantes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @GetMapping
    public String logica(){
        return "Logica de negocio de Profesor";
    }
}
