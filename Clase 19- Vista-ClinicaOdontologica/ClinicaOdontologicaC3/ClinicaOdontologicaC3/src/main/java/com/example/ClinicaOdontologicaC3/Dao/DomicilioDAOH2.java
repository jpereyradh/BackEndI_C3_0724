package com.example.ClinicaOdontologicaC3.Dao;

import com.example.ClinicaOdontologicaC3.Model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DomicilioDAOH2 implements iDao<Domicilio>{
    private static final Logger logger= Logger.getLogger(DomicilioDAOH2.class);
    private static final String SQL_SELECT_ONE="SELECT * FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("iniciando las operaciones de guardado de un domicilio");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, domicilio.getCalle());
            psInsert.setInt(2,domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute();
            ResultSet rs= psInsert.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
            }
            logger.info("domicilio persistido");

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de buscado de un domicilio");
        Connection connection= null;
        Domicilio domicilio= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            while (rs.next()){
                domicilio= new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));

            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorString(String string) {
        return null;
    }

    @Override
    public void actualizar(Domicilio domicilio) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Domicilio> buscarTodos() {
        return List.of();
    }
}
