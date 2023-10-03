package com.rolobykes.rolobykes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    @OneToMany
    private List<Reserva> Reservas;
    @OneToMany
    private List<Prestamo> Prestamos;
    private MetodoPago MetodoPago;
}

