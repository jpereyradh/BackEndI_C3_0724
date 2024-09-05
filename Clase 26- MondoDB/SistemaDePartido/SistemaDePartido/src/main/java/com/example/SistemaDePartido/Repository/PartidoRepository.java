package com.example.SistemaDePartido.Repository;

import com.example.SistemaDePartido.Entity.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidoRepository extends MongoRepository<Partido,Long> {
    //podriamos poner todas las consultas manuales de tipo HQL
}
