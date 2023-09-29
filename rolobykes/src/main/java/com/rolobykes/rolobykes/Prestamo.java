package com.rolobykes.rolobykes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class Prestamo {
    @Id
    private String Codigo;
    private Usuario Usuario;
    private Reserva Reserva;
    private Bicicleta Bicicleta;

}
