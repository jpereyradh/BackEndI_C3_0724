package com.example.tablaMovimientos.controller;

import com.example.tablaMovimientos.entity.Profesor;
import com.example.tablaMovimientos.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;


    @PostMapping
    public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.guardarProfesor(profesor));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id){
        Optional<Profesor> profesorBuscado= profesorService.buscarPorId(id);
        if(profesorBuscado.isPresent()){
            profesorService.eliminarProfesor(id);
            return ResponseEntity.ok("profesor eliminado");
        }else
            return ResponseEntity.badRequest().body("error al buscar");
    }

}
