package com.example.DirectorTecnico.controller;

import com.example.DirectorTecnico.entity.DirectorTecnico;
import com.example.DirectorTecnico.service.DirectorTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("directorTecnico")
public class DirectorTecnicoController {
    @Autowired
    private DirectorTecnicoService directorTecnicoService;


    @PostMapping
    public ResponseEntity<DirectorTecnico> registrarTecnico(@RequestBody DirectorTecnico directorTecnico){
        return ResponseEntity.ok(directorTecnicoService.registrarDirectorTecnico(directorTecnico));
    }
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<DirectorTecnico> buscarPorNombre(@PathVariable String nombre){
        Optional<DirectorTecnico> dtBuscado= directorTecnicoService.buscarPorNombre(nombre);
        if(dtBuscado.isPresent()){
            return ResponseEntity.ok(dtBuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscar/mayor/{edad}")
    public ResponseEntity<List<DirectorTecnico>> buscarMayoresQue(@PathVariable Integer edad){
        return ResponseEntity.ok(directorTecnicoService.buscarDTMayorQue(edad));
    }
}
