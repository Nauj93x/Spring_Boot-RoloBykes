package com.rolobykes.rolobykes.domain;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Usuario;
import com.rolobykes.logic.CasosDeUsoUsuario;
import com.rolobykes.logic.ExcepcionUsuario;

@SpringBootTest
public class CasosdeUsoUsuarioTests {
    
    // SUT -- Subject under test
    @Autowired
    CasosDeUsoUsuario casosDeUsoUsuario;

    // Fixing -- Clases adicionales necesarias para la prueba
    @Autowired
    UsuarioRepository usuarios;


    // Arrange
    // -------
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
        usuarios.save(u);

    }

    // CU1: Registrar Usuario
    // ----------------------

    // Curso normal de eventos -- "caso feliz"
    @Test
    public void registrarUsuarioSinErrores() {

        try {

            // Arrange

            // Act
            casosDeUsoUsuario.registrarUsuario(
                "juan", 
                "SoyElMejor", 
                "Juan El mejor");

            // Assert
            List<Usuario> usuariosConNombreJuan = usuarios.findByCorreo("juan");
            if (usuariosConNombreJuan.size() == 0) {
                // mal !!
                fail("No se grabó el usuario");
            }

        } catch (ExcepcionUsuario e) {

            // mal !!
            fail("Se generó error y no debería", e);
        }
    }

    // Curso alternativo -- 
    // (2) Cuando existe otro usuario con ese login
    @Test
    public void registrarUsuarioConLoginQueYaExiste() {

        try {

            // Arrange

            // Act
            casosDeUsoUsuario.registrarUsuario("jaime", "jaime", "jaime");

            // Assert
            fail("Dejó grabar otro usuario con un login que ya existia");

        } catch (ExcepcionUsuario e) {
            // ok !!
        }

    }

    // Curso alternativo -- 
    // (4) Cuando el password tiene menos de cinco letras
    @Test
    public void registrarUsuarioConPasswordDeMenosDe5Letras() {

        try {

            // Arrange

            // Act
            casosDeUsoUsuario.registrarUsuario(
                "jorge", 
                "xx", 
                "jorge");

            // Assert
            fail("Dejó grabar el usuario con un contraseña de menos de 5 letras");

        }  catch(ExcepcionUsuario e) {
            // ok !!
        }

    }


    // Clean Up
    // --------

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
