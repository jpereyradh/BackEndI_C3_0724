package Dao;

import Model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DomicilioDAOH2 implements iDao<Domicilio>{
    private static final Logger logger= Logger.getLogger(DomicilioDAOH2.class);
    private static final String SQL_SELECT_ONE="SELECT * FROM DOMICILIOS WHERE ID=?";
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("iniciando las operaciones de guardado de un domicilio");
        Connection connection= null;
        try{
            connection= BD.getConnection();

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
