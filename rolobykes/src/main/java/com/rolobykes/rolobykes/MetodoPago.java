package com.rolobykes.rolobykes;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class MetodoPago {
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;


}
