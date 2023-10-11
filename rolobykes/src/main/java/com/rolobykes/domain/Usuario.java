package com.rolobykes.domain;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    Long id;
    String correo;
    String password;
    String nombre;
    String sessionId;

    @OneToMany(mappedBy = "usuario")
    List<Reserva> Reservas;
    @OneToMany(mappedBy = "usuario")
    List<Prestamo> Prestamos;
}

