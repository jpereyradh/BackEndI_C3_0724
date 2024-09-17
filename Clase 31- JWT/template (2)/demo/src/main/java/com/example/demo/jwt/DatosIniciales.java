package com.example.demo.jwt;

import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String pass= "admin";
        BCryptPasswordEncoder password= new BCryptPasswordEncoder();
      String cifrado=  password.encode(pass);
        usuarioRepository.save(new Usuario("jorgito","admin@admin.com","admin",cifrado, UsuarioRole.ROLE_ADMIN));

    }
}
