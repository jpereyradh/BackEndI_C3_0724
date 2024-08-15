package com.example.ClinicaOdontologicaC3;

import com.example.ClinicaOdontologicaC3.Dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaC3Application {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(ClinicaOdontologicaC3Application.class, args);
	}

}
