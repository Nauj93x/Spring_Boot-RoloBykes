package com.rolobykes.logic;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.rolobykes.dataaccess.PrestamoRepository;
import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Prestamo;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.Usuario;

public class CasosDeUsoPrestamo {
    @Autowired
    PrestamoRepository prestamos;
    public void PrestarBicicleta(Usuario Usuario,Bicicleta bicicleta) throws ExcepcionPrestamo {
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
        prestamo
        reserva.setDuracion(Duracion); // Calcular duración
        reserva.setUsuario(usuario);
        if (.size() > 0 ) {
            // 2.1. Sistema muestra un mensaje "Existe otro usuario con ese login"
            // 2.2. Sistema termina
            throw new ExcepcionUsuario("Existe otro usuario con ese login");
        }
        // Supongamos que tienes un método para obtener el tipo de bicicleta según la bicicleta seleccionada
        reserva.setTipoBicicleta(tipoBicicleta);

        // Crear un nuevo préstamo asociado a esta reserva
        Prestamo prestamo = crearPrestamo(reserva);
        reserva.setPrestamo(prestamo);

        // Realizar la reserva (guardar en la base de datos, por ejemplo)
        guardarReservaEnBaseDeDatos(reserva);

        // Puedes agregar más acciones relacionadas con la reserva, como registrar la reserva en una base de datos, etc.
    }
}
