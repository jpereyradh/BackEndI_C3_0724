package com.example.ClinicaOdontologicaC3.Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    /*    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;*/
    private static final Logger logger= Logger.getLogger(BD.class);
    private static final String SQL_CREATE_PACIENTES="DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL, CEDULA VARCHAR(100) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT NOT NULL, EMAIL VARCHAR(100) NOT NULL)";
    private static final String SQL_CREATE_DOMICILIOS="DROP TABLE IF EXISTS DOMICILIOS; " +
            "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT NOT NULL, CALLE VARCHAR(100) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR(100) NOT NULL, PROVINCIA VARCHAR(100) NOT NULL)";
    private static final String SQL_CREATE_ODONTOLOGOS="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT, NOMBRE VARCHAR(199) NOT NULL, APELLIDO VARCHAR(199) NOT NULL, MATRICULA VARCHAR(199) NOT NULL)";
    private static final String SQL_INSERT_PRUEBA="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES " +
            "('Jorgito','Pereyra','345678','2024-08-07','1','jorgito@digitalhouse.com'); " +
            "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES('Siempre viva','748','Sprinfield','USA'); " +
            "INSERT INTO ODONTOLOGOS( NOMBRE, APELLIDO, MATRICULA) VALUES('Yesenia','Berrio','MN10')";

public static void crearTablas(){
    Connection connection=null;
    try{
        connection=getConnection();
        Statement statement= connection.createStatement();
        statement.execute(SQL_CREATE_PACIENTES);
        statement.execute(SQL_CREATE_DOMICILIOS);
        statement.execute(SQL_CREATE_ODONTOLOGOS);
        statement.execute(SQL_INSERT_PRUEBA);
        logger.info("datos cargados con exito");

    }catch (Exception e){
        logger.error("fallo en la BD: "+e.getMessage());
    }

}
    public static Connection getConnection() throws Exception{
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:mem:~/ClinicaOdontologicaC3","sa","sa");
}
}
