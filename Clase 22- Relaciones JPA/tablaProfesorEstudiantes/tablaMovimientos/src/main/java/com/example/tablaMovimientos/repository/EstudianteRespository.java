package com.example.tablaMovimientos.repository;

import com.example.tablaMovimientos.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRespository extends JpaRepository<Estudiante,Long> {
}
