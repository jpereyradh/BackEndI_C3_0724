package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Exception.ResourceNotFoundException;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
  @Operation(summary = "nos permite registrar un paciente")
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
  @GetMapping("/buscar/email/{email}")
  @Operation(summary = "busqueda de paciente por email")
  @ApiResponse(responseCode = "200",description = "paciente encontrado con exito")
  @ApiResponse(responseCode = "404", description = "paciente no encontrado")
    public ResponseEntity<Optional<Paciente>> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException{
      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorEmail(email);
      if(pacienteBuscado.isPresent()){
          return ResponseEntity.ok(pacienteBuscado);
      }else{
          //return ResponseEntity.notFound().build();
          throw new ResourceNotFoundException("paciente no encontrado por email");
      }
  }
  @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos(){
      return ResponseEntity.ok(pacienteService.listarTodos());
  }
  @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException{
      Optional<Paciente> pacienteBuscado=pacienteService.buscarPorId(id);
      if(pacienteBuscado.isPresent()){
          pacienteService.eliminarPaciente(id);
          return ResponseEntity.ok("paciente eliminado con exito");
      }else{
          throw new ResourceNotFoundException("paciente no encontrado");
          //return ResponseEntity.notFound().build();
      }

  }
}
