package com.example.ClinicaOdontologicaC3.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Odontologo {
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;
}
