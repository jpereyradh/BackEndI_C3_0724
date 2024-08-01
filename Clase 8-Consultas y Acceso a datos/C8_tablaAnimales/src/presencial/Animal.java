package presencial;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Animal {
    private static final Logger logger= Logger.getLogger(Animal.class);

    public static void main(String[] args) {
        Connection connection=null;
        try{
            connection= getConnection();
            logger.info("conexion establecida");
            Statement statement= connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ANIMALES; " +
                    "CREATE TABLE ANIMALES (ID INT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(40) NOT NULL, TIPO VARCHAR(50) NOT NULL)");
            //INSERTAR LOS ANIMALES
            System.out.println("****************************Insertando************************************");
            statement.execute("INSERT INTO ANIMALES VALUES(1,'Tom','Perro'),(2,'Firulais','Perro'),(3,'lomito','gato'),(4,'attos','Conejo'),(5,'Chester','Raton')");
            //para mostrar necesito un Objeto ResultSet

            ResultSet rs= statement.executeQuery("SELECT * FROM ANIMALES");
            while (rs.next()){
                //mostrar por pantalla
                System.out.println("Nombre: "+rs.getString(2)+" tipo: "+rs.getString(3));

            }
            System.out.println("****************************Eliminamos************************************");

            //eliminamos 1
            statement.execute("DELETE  FROM ANIMALES WHERE ID=3");
             rs= statement.executeQuery("SELECT * FROM ANIMALES");
            System.out.println("****************************Mostrando el resultado************************************");

            while (rs.next()){
                //mostrar por pantalla
                System.out.println("ID: "+rs.getInt(1)+" -Nombre: "+rs.getString(2)+" tipo: "+rs.getString(3));

            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/tablaAnimales","sa","sa");
    }



}
