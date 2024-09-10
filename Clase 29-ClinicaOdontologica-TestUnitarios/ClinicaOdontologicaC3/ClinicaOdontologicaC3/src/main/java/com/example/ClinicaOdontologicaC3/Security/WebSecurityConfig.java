package com.example.ClinicaOdontologicaC3.Security;

import com.example.ClinicaOdontologicaC3.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity //que habilite el modulo de seguridad.
public class WebSecurityConfig {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

 //necesitamos, autenticar, y dar autorizaciones
  @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }
    //ahora necesitamos otorgan las autorizaciones
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests((authz) -> authz

                       .requestMatchers("/post_pacientes.html").hasRole("USER").anyRequest().authenticated()
               )
               .formLogin(withDefaults())
               .logout(withDefaults());
       return http.build();

    }


}
