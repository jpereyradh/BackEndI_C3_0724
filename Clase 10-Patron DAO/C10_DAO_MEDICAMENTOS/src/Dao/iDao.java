package Dao;

import Model.Medicamento;

public interface iDao<T> {
    //metodos comunes a los crud de los objetos de logica de negocio
    T guardar(T t);
    T buscarPorId(Integer id);
    //eliminar
    //buscar
    //actualizar
}
