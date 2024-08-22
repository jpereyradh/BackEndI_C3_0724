package com.example.ClinicaOdontologicaC3.Dao;

import com.example.ClinicaOdontologicaC3.Model.Odontologo;
import com.example.ClinicaOdontologicaC3.Model.Turno;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TURNODAOLISTA implements iDao<Turno>{
    private static final Logger logger= Logger.getLogger(TURNODAOLISTA.class);
    private List<Turno> turnos= new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        logger.info("iniciando las operaciones de guardado de guardado de un turno");
        PacienteDAOH2 pacienteDAOH2= new PacienteDAOH2();
        OdontologoDAOH2 odontologoDAOH2= new OdontologoDAOH2();
        turno.setPaciente(pacienteDAOH2.buscarPorId(turno.getPaciente().getId()));
        turno.setOdontologo(odontologoDAOH2.buscarPorId(turno.getOdontologo().getId()));
        turnos.add(turno);
        logger.info("turno guardado");
       return turno;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de busqueda de un turno");
        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        System.out.println("turno no encontrado");
    return null;

    }

    @Override
    public Turno buscarPorString(String string) {
        return null;
    }

    @Override
    public void actualizar(Turno turno) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Turno> buscarTodos() {
        logger.info("iniciando las operaciones de busqueda de todos los turnos");

        return turnos;
    }
}
