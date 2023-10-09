package com.rolobykes.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {
    @Id
    private String Codigo;
    
    //private Usuario usuario;
    
    //private Bicicleta bicicleta;
    private Date fechaReserva;
    private int Duracion;
    private Usuario Usuario;
    private Prestamo Prestamo;
    @ManyToOne
    private TipoBicicleta TipoBicicleta;

}
