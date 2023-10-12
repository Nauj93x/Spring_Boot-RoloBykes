package com.rolobykes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Prestamo {

    @Id
    @GeneratedValue
    String codigo;

    @ManyToOne
    Usuario usuario;

    @ManyToOne
    Reserva reserva;

    @ManyToOne
    Bicicleta bicicleta;
    
    boolean activo;

}
