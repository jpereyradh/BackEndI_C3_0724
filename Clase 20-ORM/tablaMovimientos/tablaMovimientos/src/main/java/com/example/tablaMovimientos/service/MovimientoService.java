package com.example.tablaMovimientos.service;

import com.example.tablaMovimientos.entity.Movimiento;
import com.example.tablaMovimientos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private  MovimientoRepository movimientoRepository;




    public Movimiento guardarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
    public void actualizarMovimiento(Movimiento movimiento){
        movimientoRepository.save(movimiento);
    }
    public List<Movimiento> listarTodos(){
        return movimientoRepository.findAll();
    }
}
