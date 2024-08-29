package com.example.DirectorTecnico.repository;

import com.example.DirectorTecnico.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Long> {
}
