package com.example.ClinicaOdontologicaC3.Dao;

import java.util.List;

public interface iDao<T> {
    //los metodos comunes al crud
    T guardar(T t);
    T buscarPorId(Integer id);
    T buscarPorString(String string);
    void actualizar(T t);
    void eliminar(Integer id);
    List<T> buscarTodos();
}
