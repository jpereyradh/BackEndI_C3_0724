package com.example.DirectorTecnico.repository;

import com.example.DirectorTecnico.entity.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorTecnicoRespository extends JpaRepository<DirectorTecnico,Long> {
    //las consultas manuales
    List<DirectorTecnico> findByEdadGreaterThan(Integer edad);

    @Query("SELECT dt FROM DirectorTecnico dt where dt.nombre=?1")
    Optional<DirectorTecnico> buscarPorNombre(String nombre);
}
