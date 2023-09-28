package com.rolobykes.rolobykes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class MetodoPago {
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;


}
