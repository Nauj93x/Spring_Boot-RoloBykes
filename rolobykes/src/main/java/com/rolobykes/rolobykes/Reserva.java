package com.rolobykes.rolobykes;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class Reserva {
    @Id
    private String Codigo;
    private Usuario usuario;
    @Ma
    private Bicicleta bicicleta;
    private Date fechaReserva;
    private int Duracion;
    private Prestamo Prestamo;

}
