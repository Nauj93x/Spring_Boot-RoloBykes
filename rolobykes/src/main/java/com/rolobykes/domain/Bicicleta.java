package com.rolobykes.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Bicicleta {

    @Id
    @NonNull
    String codigo;

    @ManyToOne
    TipoBicicleta tipo;

    boolean disponible;

    @OneToMany(mappedBy = "bicicleta")
    List<Prestamo> prestamos = new ArrayList<>();

}
