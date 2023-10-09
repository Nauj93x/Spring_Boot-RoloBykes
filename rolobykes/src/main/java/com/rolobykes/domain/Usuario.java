package com.rolobykes.domain;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    Long id;

    String correo;
    String password;
    String nombre;

    @OneToMany(mappedBy = "usuario")
    List<Reserva> Reservas;
    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> Prestamos;

//Porque no colocamos private?

    /* 
    private String Id;


    private String Nombre;
    private String Correo;
    @OneToMany
    private List<Reserva> Reservas;
    @OneToMany
    private List<Prestamo> Prestamos;
    private MetodoPago MetodoPago;

    */
}

