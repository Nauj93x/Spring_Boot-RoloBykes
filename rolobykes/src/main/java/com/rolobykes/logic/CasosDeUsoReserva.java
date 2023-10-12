package com.rolobykes.logic;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.rolobykes.dataaccess.ReservaRepository;
import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;

public class CasosDeUsoReserva {
    @Autowired
    ReservaRepository reservas;

    public void realizarReserva(TipoBicicleta TipoBicicleta, Usuario usuario, Date fechaInicio, int Duracion) throws ExcepcionReserva {
        // Lógica para realizar la reserva

        // Crear una nueva reserva
        Reserva reserva = new Reserva();
        String codigo = UUID.randomUUID().toString().substring(0, 8);
        // Configurar la reserva con los parámetros
        reserva.setCodigo(codigo); // Generar un código único para la reserva
        reserva.setFechaReserva(fechaInicio); // Fecha actual de la reserva
        reserva.setDuracion(Duracion); // Calcular duración
        reserva.setUsuario(usuario);
        // Puedes agregar más acciones relacionadas con la reserva, como registrar la reserva en una base de datos, etc.
    }
}
