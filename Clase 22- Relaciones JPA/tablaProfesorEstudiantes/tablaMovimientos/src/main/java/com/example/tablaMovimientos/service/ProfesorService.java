package com.example.tablaMovimientos.service;

import com.example.tablaMovimientos.entity.Profesor;
import com.example.tablaMovimientos.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor guardarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }
    public Optional<Profesor> buscarPorId(Long id){
        return profesorRepository.findById(id);
    }
    public void eliminarProfesor(Long id){
        profesorRepository.deleteById(id);
    }
}
