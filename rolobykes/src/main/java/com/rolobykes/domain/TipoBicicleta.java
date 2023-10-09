package com.rolobykes.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
@Entity
public class TipoBicicleta {

    @Id
    @GeneratedValue
    Long id;

    @OneToMany
    private List<Bicicleta> BicicletasMontana;
    @OneToMany
    private List<Bicicleta> BicicletasUrbano;

    private String Nombre;
}

