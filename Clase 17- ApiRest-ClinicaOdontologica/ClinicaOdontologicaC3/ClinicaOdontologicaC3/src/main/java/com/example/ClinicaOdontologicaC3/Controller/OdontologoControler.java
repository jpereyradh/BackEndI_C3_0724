package com.example.ClinicaOdontologicaC3.Controller;


import com.example.ClinicaOdontologicaC3.Model.Odontologo;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
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
    public List<Odontologo> listarTodos(){
        return odontologoService.listarTodos();
 }
 @GetMapping("/{id}")
    public Odontologo buscarPorId(@PathVariable Integer id){
        return odontologoService.buscarPorId(id);
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
