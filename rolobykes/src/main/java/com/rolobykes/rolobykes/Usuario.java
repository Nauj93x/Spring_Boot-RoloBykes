package com.rolobykes.rolobykes;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class Usuario {
    private String Id;
    private String Nombre;
    private String Correo;
    private List<Reserva> Reservas;
    private List<Prestamo> Prestamos;
    private MetodoPago MetodoPago;
}

