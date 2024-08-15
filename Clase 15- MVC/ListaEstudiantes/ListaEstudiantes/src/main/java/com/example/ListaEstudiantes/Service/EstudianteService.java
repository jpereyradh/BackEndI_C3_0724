package com.example.ListaEstudiantes.Service;

import com.example.ListaEstudiantes.DAO.EstudianteDAOLISTA;
import com.example.ListaEstudiantes.Modelo.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

//la clase encargada de comunicar al modelo con el repositorio
@Service
public class EstudianteService {
    private EstudianteDAOLISTA estudianteDAOLISTA;

    public EstudianteService() {
        estudianteDAOLISTA= new EstudianteDAOLISTA();
    }
    public void agregarEstudiante(Estudiante estudiante){
        estudianteDAOLISTA.guardarEstudiante(new Estudiante("Jorgito","Pereyra"));
    }
    public List<Estudiante> obtenerLista(){
        estudianteDAOLISTA.guardarEstudiante(new Estudiante("Jorgito","Pereyra"));
        estudianteDAOLISTA.guardarEstudiante(new Estudiante("Juan","Pereyra"));
        estudianteDAOLISTA.guardarEstudiante(new Estudiante("Valentina","Pereyra"));
        estudianteDAOLISTA.guardarEstudiante(new Estudiante("Yesenia","Pereyra"));
        return estudianteDAOLISTA.obtenerTodos();
    }
}
