package com.example.SistemaDePartido.Service;

import com.example.SistemaDePartido.Entity.Partido;
import com.example.SistemaDePartido.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido guardarPartido(Partido partido){
        return partidoRepository.save(partido);
    }

}
