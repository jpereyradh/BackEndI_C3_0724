package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Cuentas {
   //los atributos que nos van a permitir trabajar las consultas parametrizadas
    private static final Logger logger= Logger.getLogger(Cuentas.class);
    private  static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS CUENTAS; " +
            "CREATE TABLE CUENTAS(ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10,2) NOT NULL)";
    //EL NUMERIC 10,2= 09876543,21
    private static final String SQL_INSERT="INSERT INTO CUENTAS VALUES (?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE CUENTAS SET SALDO=? WHERE ID=?";

    public static void main(String[] args) {
        Connection connection= null;
        try{
            connection= getConnection();
            //crear la tabla
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            logger.info("tabla creada con exito");
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            //ahora debemos ingresar las parametrizadas
            psInsert.setInt(1,1);
            psInsert.setString(2,"Valeria");
            psInsert.setInt(3,11111111);
            psInsert.setDouble(4,200);
            psInsert.execute(); //--> estos datos se confirmaron
            logger.info(" primera carga de datos cargados con exito");
            //ahora debemos sumar 10 al saldo

            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,200+10);
            psUpdate.setInt(2,1); //--> ID=1, Ub=2
            psUpdate.execute(); //--> este fue el savepoint
            logger.info(" segunda carga de datos cargados con exito");
            connection.setAutoCommit(false);
            //los datos se volvieron a confirmar
            PreparedStatement psTx= connection.prepareStatement(SQL_UPDATE);
            psTx.setDouble(1,200+10+15);
            psTx.setInt(2,1);

            //int x=4/0;
            psTx.execute();
            logger.info("saldo nuevamente actualizado con exito");

            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e){
            //logger.error(e.getMessage());
            try{
                connection.rollback();
            }catch (SQLException sql){
                logger.error(sql.getMessage());
            }
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/TablaCuentas","admin","admin");
    }
}
