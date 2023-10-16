package com.rolobykes.rolobykes.domain;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.rolobykes.dataaccess.BicicletaRepository;
import com.rolobykes.dataaccess.ReservaRepository;
import com.rolobykes.dataaccess.TipoBicicletaRepository;
import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;
import com.rolobykes.logic.CasosDeUsoReserva;
import com.rolobykes.logic.CasosDeUsoUsuario;
import com.rolobykes.logic.ExcepcionReserva;

@SpringBootTest
public class CasosdeUsoReservaTests {

    // SUT -- Subject under test
    @Autowired
    CasosDeUsoReserva casosDeUsoReserva;

    // Fixing -- Clases adicionales necesarias para la prueba
    @Autowired
    ReservaRepository reservas;

    @Autowired
    UsuarioRepository usuarios;

    @Autowired
    TipoBicicletaRepository tiposbicicletas;

    @Autowired
    CasosDeUsoUsuario casosDeUsoUsuario;

    @Autowired
    TipoBicicletaRepository tiposBicicleta;
    
    @Autowired
    BicicletaRepository bicicletas;
    
    @BeforeAll
    public static void prepararAmbienteParaTodaLaSuite() {
        System.out.println("Antes de todas las pruebas de la clase");
        System.out.println();
    }
    
    @BeforeEach
    public void prepararAmbienteDePruebas() {
        System.out.println("Antes de cada pruebas");
        System.out.println();

        usuarios.deleteAll();
        Usuario u = new Usuario();
        u.setCorreo("jaime");
        u.setNombre("jaime");
        u.setPassword("jaime");
        u.setSessionId("hola");
        usuarios.save(u);

    }

        // CU1: Registrar Reserva
    // ----------------------

    // Curso normal de eventos -- "caso feliz"
    @Test
    @Transactional
    public void realizarReservaSinErrores() {
        try {
            List<Usuario> usuariosExistentes = usuarios.findByCorreo("jaime");
            Usuario u = usuariosExistentes.get(0);

            TipoBicicleta tipo = new TipoBicicleta("montaña");
            tipo = tiposBicicleta.save(tipo);

            Bicicleta bicicleta = new Bicicleta("MyBici");

            bicicleta.setTipo(tipo);
            tipo.getBicicletas().add(bicicleta);

            bicicleta = bicicletas.save(bicicleta);
            tipo = tiposBicicleta.save(tipo);

            Date fecha = new Date(1230768000000L);

            casosDeUsoReserva.realizarReserva(tipo, u, fecha, 2);
            List<Reserva> reservasIniciadas = reservas.findByFechaReserva(fecha);
            if (reservasIniciadas.size() == 0) {
                // mal !!
                fail("No se grabó la reserva");
            }
            
        } catch (Exception e) {
            fail("No dejo guardar la reserva",e);
        }

    }

    @Test
    @Transactional
    public void realizarReservaConUsuarioSinSesion() {
        try {
            casosDeUsoUsuario.registrarUsuario(
                "juan", 
                "SoyElMejor", 
                "Juan El mejor");
            List<Usuario> usuariosExistentes = usuarios.findByCorreo("juan");
            Usuario u = usuariosExistentes.get(0);

            TipoBicicleta tipo = new TipoBicicleta("montaña");
            tipo = tiposBicicleta.save(tipo);

            Bicicleta bicicleta = new Bicicleta("MyBici");

            bicicleta.setTipo(tipo);
            tipo.getBicicletas().add(bicicleta);

            bicicleta = bicicletas.save(bicicleta);
            tipo = tiposBicicleta.save(tipo);

            Date fecha = new Date(1230768000000L);

            casosDeUsoReserva.realizarReserva(tipo, u, fecha, 2);
            fail("Dejó hacer reserva a usuario que no ha iniciado sesión");
            
        } catch (Exception e) {
            //ok
        }

    }

    @Test
    @Transactional
    public void realizarReservaConTipoNoExistente() {
        try {
            casosDeUsoUsuario.registrarUsuario(
                "juan", 
                "SoyElMejor", 
                "Juan El mejor");
            List<Usuario> usuariosExistentes = usuarios.findByCorreo("juan");
            Usuario u = usuariosExistentes.get(0);

            TipoBicicleta tipo = new TipoBicicleta("montaña");

            Bicicleta bicicleta = new Bicicleta("MyBici");

            bicicleta.setTipo(tipo);
            tipo.getBicicletas().add(bicicleta);

            bicicleta = bicicletas.save(bicicleta);
            tipo = tiposBicicleta.save(tipo);

            Date fecha = new Date(1230768000000L);

            casosDeUsoReserva.realizarReserva(tipo, u, fecha, 2);
            fail("Dejó hacer reserva a usuario que ingreso tipo de bicicleta no existente ");
            
        } catch (Exception e) {
            //ok
        }

    }

    @Test
    @Transactional
    public void realizarReservaConUsuarioNoRegistrado() {
        try {

            List<Usuario> usuariosExistentes = usuarios.findByCorreo("juan");
            Usuario u = usuariosExistentes.get(0);

            TipoBicicleta tipo = new TipoBicicleta("montaña");

            Bicicleta bicicleta = new Bicicleta("MyBici");

            bicicleta.setTipo(tipo);
            tipo.getBicicletas().add(bicicleta);

            bicicleta = bicicletas.save(bicicleta);
            tipo = tiposBicicleta.save(tipo);

            Date fecha = new Date(1230768000000L);

            casosDeUsoReserva.realizarReserva(tipo, u, fecha, 2);
            fail("Dejó hacer reserva a usuario no registrado");
            
        } catch (Exception e) {
            //ok
        }

    }


    @AfterEach
    public void despuesDeLaPrueba() {
        System.out.println("Luego de cada prueba");
        System.out.println();
    }

    @AfterAll
    public static void despuesDeTodasLasPruebas() {
        System.out.println("Luego de todas las pruebas");
        System.out.println();
    }
}
