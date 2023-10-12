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
public class TipoBicicleta {

    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String nombre;

    // atributo que tiene el foreignKey
    @OneToMany(mappedBy = "tipo")
    List<Bicicleta> bicicletas = new ArrayList<>();

    @OneToMany(mappedBy = "tipoBicicleta")
    List<Reserva> reservas = new ArrayList<>();

}

