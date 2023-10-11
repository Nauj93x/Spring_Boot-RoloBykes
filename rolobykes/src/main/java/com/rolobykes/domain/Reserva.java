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
    String Codigo;
    Date fechaReserva;
    int Duracion;
    Usuario Usuario;
    Prestamo Prestamo;
    @ManyToOne
    TipoBicicleta TipoBicicleta;

}
