package com.rolobykes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Prestamo {
    @Id
    String Codigo;
    @ManyToOne
    Usuario Usuario;
    @OneToMany(mappedBy = "prestamo")
    Reserva Reserva;
    @ManyToOne
    Bicicleta Bicicleta;
    boolean Activo;

}
