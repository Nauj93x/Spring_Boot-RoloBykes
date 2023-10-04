package com.rolobykes.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.PrestamoRepository;

@Service
public class PrestamoUseCase {
    
    @Autowired
    PrestamoRepository prestamos;

    public void crearPrestamos(){
        
    }
}
