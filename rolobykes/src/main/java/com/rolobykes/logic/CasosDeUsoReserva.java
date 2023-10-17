package com.rolobykes.logic;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.PrestamoRepository;
import com.rolobykes.dataaccess.ReservaRepository;
import com.rolobykes.dataaccess.TipoBicicletaRepository;
import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Prestamo;
import com.rolobykes.domain.Prestamo;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;

@Service
public class CasosDeUsoReserva {
    @Autowired
    ReservaRepository reservas;
	@Autowired
    PrestamoRepository prestamos;
	@Autowired
    UsuarioRepository usuarios;
	@Autowired
    TipoBicicletaRepository tiposbicicletas;

    public void realizarReserva(TipoBicicleta tipoBicicleta, Usuario usuario, Date fechaInicio, int duracion) throws ExcepcionReserva {
		// Crear una nueva reserva
		Reserva reserva = new Reserva();
		reserva.setFechaReserva(fechaInicio); // Fecha actual de la reserva
		reserva.setDuracion(duracion); // Calcular duración

		List<Usuario> usuariosExistentes = usuarios.findByCorreo(usuario.getCorreo());

		if (usuariosExistentes.isEmpty()) {
			// 2.1. Sistema muestra un mensaje "No existen usuarios con este correo"
			// 2.2. Sistema termina
			throw new ExcepcionReserva("No existen usuarios con este correo");
		}
		Usuario usuarioEncontrado = usuariosExistentes.get(0);
		if (usuarioEncontrado.getSessionId() == null){
			throw new ExcepcionReserva("Este usuario no ha iniciado sesion");
		}
		List<TipoBicicleta> tiposExistentes = tiposbicicletas.findByNombre(tipoBicicleta.getNombre());
		if (tiposExistentes.isEmpty()) { 
			// 2.1. Sistema muestra un mensaje "No existen usuarios con este correo"
			// 2.2. Sistema termina
			throw new ExcepcionReserva("No existe ese tipo de bicicleta");
		}
		Prestamo prest = new Prestamo();
		prest = prestamos.save(prest);
		reserva.getPrestamos().add(prest);
		reserva.setUsuario(usuario);
		// Asignar reserva al usuario
		usuario.getReservas().add(reserva);
		reserva.setTipoBicicleta(tipoBicicleta);
		reserva.setUsuario(usuario);
		// Guardar reserva y prestamo relacionado
		reservas.save(reserva);
		// Guardar usuario con la nueva reserva
		usuarios.save(usuario);
    }
}
