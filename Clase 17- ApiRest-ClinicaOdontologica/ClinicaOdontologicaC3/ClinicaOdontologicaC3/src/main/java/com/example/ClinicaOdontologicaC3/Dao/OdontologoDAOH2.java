package com.example.ClinicaOdontologicaC3.Dao;

import com.example.ClinicaOdontologicaC3.Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_ONE="SELECT * FROM ODONTOLOGOS WHERE ID=?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("iniciando las operaciones de guardado de un odontologo");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.setString(3, odontologo.getMatricula());
            psInsert.execute(); //generamos los ID
            ResultSet clave= psInsert.getGeneratedKeys();
            while(clave.next()){
                odontologo.setId(clave.getInt(1));
            }
            logger.info("ID asignado: "+odontologo.getId());

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de busqueda de un odontologo con id: "+id);
        Connection connection= null;
        Odontologo odontologo= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            while(rs.next()){
                odontologo= new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            logger.info("odontologo encontrado:  "+odontologo.getNombre());

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorString(String string) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("iniciando las operaciones de busqueda de todos los odontologos");
        Connection connection= null;
        Odontologo odontologo= null;
        List<Odontologo> listaOdontologos= new ArrayList<>();
        try{
            connection= BD.getConnection();
            Statement statement= connection.createStatement();
           ResultSet lista= statement.executeQuery(SQL_SELECT_ALL);
           while (lista.next()){
           odontologo= new Odontologo(lista.getInt(1), lista.getString(2),lista.getString(3),lista.getString(4));
           listaOdontologos.add(odontologo);
           }
           logger.info("lista cargada");

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return listaOdontologos;
   }
}
