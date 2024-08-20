package com.example.ClinicaOdontologicaC3.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Domicilio {

    private Integer id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;


}
