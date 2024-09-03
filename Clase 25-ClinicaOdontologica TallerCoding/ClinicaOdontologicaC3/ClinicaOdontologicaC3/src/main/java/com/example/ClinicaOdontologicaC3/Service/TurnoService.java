package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
}
