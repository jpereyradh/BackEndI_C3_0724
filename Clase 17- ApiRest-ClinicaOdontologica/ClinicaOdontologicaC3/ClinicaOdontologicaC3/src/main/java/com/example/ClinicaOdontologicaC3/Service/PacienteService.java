package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Dao.PacienteDAOH2;
import com.example.ClinicaOdontologicaC3.Dao.iDao;
import com.example.ClinicaOdontologicaC3.Model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }
    //metodos manuales CRUD
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorId(Integer id){
        return pacienteiDao.buscarPorId(id);
    }
    public Paciente buscarPorCorreo(String email){
        return pacienteiDao.buscarPorString(email);
    }
}
