package com.example.DirectorTecnico.service;

import com.example.DirectorTecnico.entity.DirectorTecnico;
import com.example.DirectorTecnico.repository.DirectorTecnicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorTecnicoService {
    @Autowired
    private DirectorTecnicoRespository directorTecnicoRespository;

    public DirectorTecnico registrarDirectorTecnico(DirectorTecnico directorTecnico){
        return directorTecnicoRespository.save(directorTecnico);
    }
    public List<DirectorTecnico> buscarDTMayorQue(Integer edad){
        return directorTecnicoRespository.findByEdadGreaterThan(edad);
    }
    public Optional<DirectorTecnico> buscarPorNombre(String nombre){
        return directorTecnicoRespository.buscarPorNombre(nombre);
    }
}
