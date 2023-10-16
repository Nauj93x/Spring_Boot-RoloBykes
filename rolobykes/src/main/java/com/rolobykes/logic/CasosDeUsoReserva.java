package com.rolobykes.logic;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.ReservaRepository;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;

@Service
public class CasosDeUsoReserva {
    @Autowired
    ReservaRepository reservas;

    public void realizarReserva(TipoBicicleta TipoBicicleta, Usuario usuario, Date fechaInicio, int Duracion) throws ExcepcionReserva {
        // Lógica para realizar la reserva

        // Crear una nueva reserva
        Reserva reserva = new Reserva();
        // Configurar la reserva con los parámetros
        reserva.setFechaReserva(fechaInicio); // Fecha actual de la reserva
        reserva.setDuracion(Duracion); // Calcular duración
        reserva.setUsuario(usuario);
        // Puedes agregar más acciones relacionadas con la reserva, como registrar la reserva en una base de datos, etc.
    }
}
