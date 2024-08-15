package DigitalHouse_BackendI.Animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //no se utiliza entonces tecnologia de vista
public class AnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
	}


	@PostMapping("/1")
	public String saludo1(){
		return "Primer Saludo";
	}
	@GetMapping("/2")
	public String saludos2(){
		return "Segundo Saludo";
	}

}
