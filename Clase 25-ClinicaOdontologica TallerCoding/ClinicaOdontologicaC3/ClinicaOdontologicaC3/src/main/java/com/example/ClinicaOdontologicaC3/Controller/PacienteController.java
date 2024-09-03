package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;


  @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
  }
  @PutMapping
   public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente){
      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorId(paciente.getId());
      if(pacienteBuscado.isPresent()){
          pacienteService.actualizarPaciente(paciente);
          return ResponseEntity.ok("paciente actualizado con exito");
      }else{
          return ResponseEntity.badRequest().body("paciente no encontrado");
      }
  }
  @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable Long id){
      return ResponseEntity.ok(pacienteService.buscarPorId(id));
  }
  @GetMapping("/buscar/{email}")
    public ResponseEntity<Optional<Paciente>> buscarPorEmail(@PathVariable String email){
      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorEmail(email);
      if(pacienteBuscado.isPresent()){
          return ResponseEntity.ok(pacienteBuscado);
      }else{
          return ResponseEntity.notFound().build();
      }
  }
  @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos(){
      return ResponseEntity.ok(pacienteService.listarTodos());
  }
}