package com.example.ClinicaOdontologicaC3.Dao;

import com.example.ClinicaOdontologicaC3.Model.Domicilio;
import com.example.ClinicaOdontologicaC3.Model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente>{
    private static final Logger logger= Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) " +
            "VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=? ";
    private static final String SQL_SELECT_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";
    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("iniciando las operaciones de guardado de un paciente");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5,paciente.getDomicilio().getId());
            psInsert.setString(6, paciente.getEmail());

           ResultSet rs= psInsert.getGeneratedKeys();
            while(rs.next()){
                paciente.setId(rs.getInt(1));
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de buscado de un paciente");
        Connection connection= null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection= BD.getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                domicilio= daoAux.buscarPorId(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorString(String string) {
        logger.info("iniciando las operaciones de busqueda: "+string);
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        DomicilioDAOH2 daoAux=new DomicilioDAOH2();
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectEmail= connection.prepareStatement(SQL_SELECT_EMAIL);
            psSelectEmail.setString(1,string);
            ResultSet rs= psSelectEmail.executeQuery();
            while (rs.next()){
                domicilio= daoAux.buscarPorId(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
            }

        }catch (Exception e){
            logger.error("fallo en la conexion: "+e.getMessage());
        }if(paciente!=null){
            logger.info("paciente encontrado con exito");
        }else{
            logger.warn("error en la busqueda, paciente null");
        }
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("iniciando las operaciones de guardado de actualizado de un paciente");
        Connection connection= null;
        try{
            connection= BD.getConnection();

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }

    }

    @Override
    public void eliminar(Integer id) {
        logger.info("iniciando las operaciones de guardado de un paciente");
        Connection connection= null;
        try{
            connection= BD.getConnection();

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }

    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("iniciando las operaciones de guardado de un paciente");
        Connection connection= null;
        try{
            connection= BD.getConnection();

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return List.of();
    }
}
