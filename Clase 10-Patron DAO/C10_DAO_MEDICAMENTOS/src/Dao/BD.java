package Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
   /* private Integer id;
    private String nombre;
    private int codigoNumerico;
    private String laboratorio;
    private Double precio;
    private Integer cantidad;*/
    private static final Logger logger= Logger.getLogger(BD.class);
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS MEDICAMENTOS; " +
            "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, CODIGO_NUMERICO INT NOT NULL, " +
            "LABORATORIO VARCHAR(100) NOT NULL, PRECIO NUMERIC(10,2) NOT NULL, CANTIDAD INT NOT NULL)";
public static void crearTabla(){
    Connection connection= null;
    try{
        connection= getConnection();
        Statement statement= connection.createStatement();
        statement.execute(SQL_DROP_CREATE);
        logger.info("tabla creada con exito");
    }catch (Exception e){
        logger.error(e.getMessage());
    }
}
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/DaoMedicamentos","sa","sa");
    }
}
