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
    @OneToMany(mappedBy = "TipoBicicleta")
    List<Bicicleta> BicicletasMontana;
    @OneToMany(mappedBy = "TipoBicicleta")
    List<Bicicleta> BicicletasUrbano;
    String Nombre;
}

