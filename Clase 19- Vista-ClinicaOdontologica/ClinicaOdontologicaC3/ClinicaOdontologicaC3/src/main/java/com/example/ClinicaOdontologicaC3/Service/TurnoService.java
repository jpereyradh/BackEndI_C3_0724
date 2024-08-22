package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Dao.TURNODAOLISTA;
import com.example.ClinicaOdontologicaC3.Dao.iDao;
import com.example.ClinicaOdontologicaC3.Model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private iDao<Turno> turnoiDao;

    public TurnoService() {
        turnoiDao= new TURNODAOLISTA();
    }

    public Turno guardarTurno(Turno turno){
        return turnoiDao.guardar(turno);
    }
    public Turno buscarPorId(Integer id){
        return turnoiDao.buscarPorId(id);
    }
    public List<Turno> listarTodos(){
        return turnoiDao.buscarTodos();
    }
}
