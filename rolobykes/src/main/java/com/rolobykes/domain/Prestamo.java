package com.rolobykes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor

public class Prestamo {

    @Id
    @GeneratedValue
    Long codigo;

    @ManyToOne
    Usuario usuario;

    @ManyToOne
    Reserva reserva;

    @NonNull
    @ManyToOne
    Bicicleta bicicleta;

    boolean activo;

}
