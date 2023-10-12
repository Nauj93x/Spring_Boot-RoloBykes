package com.rolobykes.logic;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.rolobykes.dataaccess.BicicletaRepository;
import com.rolobykes.dataaccess.PrestamoRepository;
import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Prestamo;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;

public class CasosDeUsoPrestamo {
    @Autowired
    PrestamoRepository prestamos;
    BicicletaRepository bicicletas;
    public void PrestarBicicleta(Usuario Usuario,TipoBicicleta tipo) throws ExcepcionPrestamo {
        Prestamo prestamo = new Prestamo();
        String codigo = UUID.randomUUID().toString().substring(0, 8);
        // Configurar la reserva con los parámetros
        prestamo.setCodigo(codigo); // Generar un código único para la reserva
        if (Usuario.getSessionId() == null) {
            // 2.1. Sistema muestra un mensaje "El usuario no ha iniciado sesion"
            // 2.2. Sistema termina
            throw new ExcepcionPrestamo("El usuario no ha iniciado sesion");
        }
        prestamo.setUsuario(Usuario);
        prestamo.setActivo(true);
        boolean Estado = true;
        // List<Bicicleta> bici = bicicletas.findByTipoBicicleta(tipo); 
        

    }
}
