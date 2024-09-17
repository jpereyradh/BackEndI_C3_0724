package com.example.demo.jwt;

import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /*Optional<Usuario> usuaioBuscado= usuarioRepository.findByUsername(userName);
        if(usuaioBuscado.isPresent()){
            return usuaioBuscado.get();
        }else{
            throw new UsernameNotFoundException("usuario no encontrado");
        }*/
    return usuarioRepository.findByUserName(userName).orElseThrow(null);
        //return new User("foo", "foo", new ArrayList<>());
    }
}
