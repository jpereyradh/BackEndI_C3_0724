package com.example.ListaEstudiantes.Controller;

import com.example.ListaEstudiantes.Modelo.Estudiante;
import com.example.ListaEstudiantes.Service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    //service
    private EstudianteService estudianteService;

    public EstudianteController() {
        estudianteService= new EstudianteService();
    }
    @GetMapping("/lista")
    public List<Estudiante> obtenerLista(){
        return estudianteService.obtenerLista();
    }
}
