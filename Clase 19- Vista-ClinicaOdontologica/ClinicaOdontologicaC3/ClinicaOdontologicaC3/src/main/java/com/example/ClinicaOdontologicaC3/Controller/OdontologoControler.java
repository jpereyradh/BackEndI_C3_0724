package com.example.ClinicaOdontologicaC3.Controller;


import com.example.ClinicaOdontologicaC3.Model.Odontologo;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoControler {
    private OdontologoService odontologoService;

    public OdontologoControler() {
        odontologoService= new OdontologoService();
    }

 @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
 }
 @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
 }
 @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
     Odontologo odontologoBuscado= odontologoService.buscarPorId(id);
                if(odontologoBuscado!=null){
     return ResponseEntity.ok(odontologoBuscado);
                                        }
    else{
        return ResponseEntity.notFound().build();
                }
    }
 @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id ){
        Odontologo odontologoBuscado= odontologoService.buscarPorId(id);
        if(odontologoBuscado!=null){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("odontologo eliminado con exito");
        }else{
            return ResponseEntity.badRequest().body("odontologo inexistente o error en la busqueda");
        }
 }
 /*
 * Opción 1:
 * GetMapping("/buscar") buscarPorId(@RequestParam Integer id)
 *  RequestParam ---> buscar?id=1 --> postman
 *
 * GetMapping("/{id}")
   buscarPorId(@PathVariable Integer id)
 * Postman:
   Opción 2: Pathvariable -->/1
 *
 * */
}
