package com.example.ClinicaOdontologicaC3.Security;

import com.example.ClinicaOdontologicaC3.Entity.Usuario;
import com.example.ClinicaOdontologicaC3.Entity.UsuarioRole;
import com.example.ClinicaOdontologicaC3.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "admin";
        String passCifrado= bCryptPasswordEncoder.encode(passSinCifrar);
        System.out.println("pass cifrado: "+passCifrado);
        Usuario usuario= new Usuario("Jorgito","jpereyradh","jorge.pereyra@digitalhouse.com",passCifrado, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
    }
}
