package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Dao.OdontologoDAOH2;
import com.example.ClinicaOdontologicaC3.Dao.iDao;
import com.example.ClinicaOdontologicaC3.Model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
         odontologoiDao = new OdontologoDAOH2();
        }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }
    public Odontologo buscarPorId(Integer id){
        return odontologoiDao.buscarPorId(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoiDao.actualizar(odontologo);
    }
    public void eliminarOdontologo(Integer id){

        odontologoiDao.eliminar(id);
    }
    public List<Odontologo> listarTodos(){
        return odontologoiDao.buscarTodos();
    }
}
