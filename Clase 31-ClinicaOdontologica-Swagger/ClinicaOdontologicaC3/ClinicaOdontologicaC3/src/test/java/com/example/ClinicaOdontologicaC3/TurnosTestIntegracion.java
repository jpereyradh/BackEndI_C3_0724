package com.example.ClinicaOdontologicaC3;

import com.example.ClinicaOdontologicaC3.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaC3.Entity.Domicilio;
import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import com.example.ClinicaOdontologicaC3.Service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //desactivamos la seg
public class TurnosTestIntegracion {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private MockMvc mockMvc; //va a ser el objeto que nos lleve a ejecutar el test


    public void cargarDatos(){
        Paciente paciente= pacienteService.registrarPaciente(new Paciente("Jorgito","Pereyra","1111111", LocalDate.of(2024,9,11),new Domicilio("calle 1",12,"La Rioja", "Argentina"),"jorgito@digitalhouse.com"));
        Odontologo odontologo= odontologoService.registrarOdontologo(new Odontologo("Matias","Torres","1223"));
        TurnoDTO turnoDTO= turnoService.registrarTurno(new Turno(paciente,odontologo,LocalDate.of(2024,9,21)));
    }
    @Test
    public void listarTurnos() throws Exception{
        cargarDatos();
        MvcResult respuesta= mockMvc.perform(MockMvcRequestBuilders.get("/turno").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
