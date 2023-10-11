package com.rolobykes.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
public class Bicicleta {
    @Id
    private String Codigo;
    @ManyToOne
    private TipoBicicleta Tipo;
    private String Estado;
    @OneToMany(mappedBy = "bicicleta")
    private List<Prestamo> Prestamos;

}
