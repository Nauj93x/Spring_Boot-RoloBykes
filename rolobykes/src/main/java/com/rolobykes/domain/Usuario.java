package com.rolobykes.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String nombre;

    @NonNull
    String correo;

    @NonNull
    String password;

    String sessionId = null;

    @OneToMany(mappedBy = "usuario")
    List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    List<Prestamo> prestamos = new ArrayList<>();
}

