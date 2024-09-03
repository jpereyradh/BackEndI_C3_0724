package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoDTO registrarTurno(Turno turno){
         Turno turnoGuardado= turnoRepository.save(turno);
         return turnoATurnoDto(turnoGuardado);
    }

    public TurnoDTO turnoATurnoDto(Turno turno){
        TurnoDTO dto= new TurnoDTO();
        dto.setId(turno.getId());
        dto.setFecha(turno.getFecha());
        dto.setOdontologoId(turno.getOdontologo().getId());
        dto.setPacienteId(turno.getPaciente().getId());
        return dto;
    }
}
