package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Model.Paciente;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController() {
        pacienteService= new PacienteService();
    }
  @PostMapping
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
  }
/* @PutMapping
  public String actualizarPaciente(Paciente paciente){
        return pacienteService.
  }*/
}
