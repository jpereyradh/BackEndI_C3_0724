package com.example.DirectorTecnico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "directores_tecnicos")
public class DirectorTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private Integer edad;
    @OneToMany(mappedBy = "directorTecnico",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Jugador> jugadores= new ArrayList<>();
}
