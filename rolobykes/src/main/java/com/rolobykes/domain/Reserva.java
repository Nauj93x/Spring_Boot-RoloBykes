package com.rolobykes.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Reserva {


    @Id
    @GeneratedValue
    String codigo;

    @NonNull
    @Temporal(TemporalType.DATE)
    Date fechaReserva;

    @NonNull
    Integer duracion;
    
    @ManyToOne
    Usuario usuario;

    @OneToMany(mappedBy = "reserva")
    List<Prestamo> prestamos;

    @ManyToOne
    TipoBicicleta tipoBicicleta;

}
