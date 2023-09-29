package com.rolobykes.rolobykes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
public class Bicicleta {
    @Id
    private String Codigo;
    private TipoBicicleta Tipo;
    private String Estado;
    private List<Prestamo> Prestamos;

}
