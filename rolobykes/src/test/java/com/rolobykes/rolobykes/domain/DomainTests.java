package com.rolobykes.rolobykes.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.rolobykes.dataaccess.BicicletaRepository;
import com.rolobykes.dataaccess.PrestamoRepository;
import com.rolobykes.dataaccess.ReservaRepository;
import com.rolobykes.dataaccess.TipoBicicletaRepository;
import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Prestamo;
import com.rolobykes.domain.Reserva;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;

@SpringBootTest
public class DomainTests {

    @Autowired
    UsuarioRepository usuarios;

    @Autowired
    TipoBicicletaRepository tiposBicicleta;

    @Autowired
    BicicletaRepository bicicletas;

    @Autowired
    ReservaRepository reservas;

    @Autowired 
    PrestamoRepository prestamos;

    @BeforeEach
    public void borrarBD() {
        reservas.deleteAll();

        prestamos.deleteAll();

        bicicletas.deleteAll();
        
        tiposBicicleta.deleteAll();

        usuarios.deleteAll();
    }

    @Test
    public void crearUsuario() {

        try {

            // -- Arrange

            // crea el objeto
            Usuario u = new Usuario(
                    "bill",
                    "bill@microsoft.com",
                    "ILoveApple");

            // -- Act

            // guardar en la base de datos
            // retorna un objeto enlazado a la base de datos
            u = usuarios.save(u);

            // -- Assert

            assertNotNull(u, "El ususario quedó en NULL");
            assertNotNull(u.getId(), "El id quedó en NULL");

            List<Usuario> usuariosEnBD = usuarios.findByCorreo("bill@microsoft.com");
            assertTrue(usuariosEnBD.size() > 0, "No encontro un usuario con ese correo");

            Usuario usuarioEnBD = usuariosEnBD.get(0);
            assertNotNull(usuarioEnBD, "el usuario está en NULL");
            assertEquals(u.getNombre(), "bill", "El nombre no coincide");


        } catch (Exception e) {
            fail("No dejó grabar", e);
        }

    }

    @Test
    public void crearTipoBicicleta() {

        try {

            TipoBicicleta tipo = new TipoBicicleta("montaña");

            tipo = tiposBicicleta.save(tipo);

            // -- Assert


        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test
    @Transactional
    public void crearBicicleta() {

        try {

            // -- Arrange

            TipoBicicleta tipo = new TipoBicicleta("montaña");
            tipo = tiposBicicleta.save(tipo);


            // -- Act

            // creo el objeto
            Bicicleta bicicleta = new Bicicleta("MyBici");

            // asociar con otros objetos
            bicicleta.setTipo(tipo);
            tipo.getBicicletas().add(bicicleta);

            bicicleta = bicicletas.save(bicicleta);
            tipo = tiposBicicleta.save(tipo);


            // -- Assert

            List<TipoBicicleta> tiposEnBD = tiposBicicleta.findByNombre("montaña");
            assertTrue(tiposEnBD.size() > 0, "No hay tipos en la BD");

            TipoBicicleta tipoEnBD = tiposEnBD.get(0);
            assertNotNull(tipoEnBD, "El tipo es NULL");
            assertNotNull(tipoEnBD.getBicicletas(), "El tipo no tiene bicicletas");
            assertTrue(tipoEnBD.getBicicletas().size() > 0, "El tipo no tiene biciletas");

            Bicicleta bicicletaEnBD = tipoEnBD.getBicicletas().get(0);
            assertNotNull(bicicletaEnBD, "La bicicleta en la BD está en NULL");
            assertEquals(bicicletaEnBD.getCodigo(), "MyBici", "El codigo de la bicicleta en la BD no coincide");

        } catch (Exception e) {
            fail("No dejó grabar", e);
        }

    }

    @Test
    public void crearReserva(){

        try {
            // -- Arrange
            Date fecha = new Date(1230768000000L);
            Usuario u = new Usuario(
                "bill", 
                "bill@microsoft.com",
                "ILoveApple");
            u = usuarios.save(u);
            Integer dur = 2;
            TipoBicicleta tipo = new TipoBicicleta("montaña");
            tipo = tiposBicicleta.save(tipo);
            
            Bicicleta bicicleta = new Bicicleta("MyBici");
            bicicleta.setTipo(tipo);
            tipo.getBicicletas().add(bicicleta);
            bicicleta = bicicletas.save(bicicleta);
            tipo = tiposBicicleta.save(tipo);
            Prestamo prest = new Prestamo(bicicleta);
            prest.setActivo(true);
            prest = prestamos.save(prest);
            List<Prestamo> presta = new ArrayList<>();
            presta.add(prest);
            // -- Act
            Reserva reserva = new Reserva(fecha,dur);
            reserva.setUsuario(u);
            reserva.setPrestamos(presta);
            reserva = reservas.save(reserva);

            // -- Assert
            List<Reserva> reservasEnBD = reservas.findByFechaReserva(fecha);
            assertTrue(reservasEnBD.size()> 0, "No hay reservas en la BD");


        } catch (Exception e) {
            fail("No dejó grabar", e);
        }
    }

    @Test
    @Transactional
    public void crearPrestamo(){
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
