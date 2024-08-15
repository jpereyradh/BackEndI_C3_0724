package com.example.ListaEstudiantes.DAO;

import com.example.ListaEstudiantes.Modelo.Estudiante;

import java.util.ArrayList;
import java.util.List;


public class EstudianteDAOLISTA {
    private List<Estudiante> estudianteList;

    public EstudianteDAOLISTA() {
        estudianteList= new ArrayList<>();
    }
    public void guardarEstudiante(Estudiante estudiante){
        estudianteList.add(estudiante);
    }
    public List<Estudiante> obtenerTodos(){
        return estudianteList;
    }

}
