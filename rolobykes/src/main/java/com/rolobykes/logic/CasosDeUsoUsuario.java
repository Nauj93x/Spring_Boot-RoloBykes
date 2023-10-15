package com.rolobykes.logic;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Usuario;

@Service
public class CasosDeUsoUsuario {
    
    @Autowired
    UsuarioRepository usuarios;

    // CU1: Registrar Usuario
    public void registrarUsuario (
        String login,       // 1. Actor ingresa login
        String password,    // 3. Actor ingresa password
        String nombre       // 5. Actor ingresa nombre
    ) throws ExcepcionUsuario {

        // 2. Sistema valida que no exista otro usuario con ese login
        List<Usuario> usuariosExistentes = usuarios.findByCorreo(login);

        // (2) Cuando existe otro usuario con ese login
        if (usuariosExistentes.size() > 0 ) {
            // 2.1. Sistema muestra un mensaje "Existe otro usuario con ese login"
            // 2.2. Sistema termina
            throw new ExcepcionUsuario("Existe otro usuario con ese login");
        }

        // 4. Sistema valida que el password tenga más de cinco letras 
        // (4) Cuando el password tiene menos de cinco letras
        if (password.trim().length() < 5) {
            // 4.1. Sistema muestra un mensaje "El password tiene menos de cinco letras"
            // 4.2. Sistema termina.
            throw new ExcepcionUsuario("El password tiene menos de cinco letras");
        }

        // 6. Sistema registra el usuario
        Usuario u = new Usuario();
        u.setCorreo(login);
        u.setNombre(nombre);
        u.setPassword(password);

        usuarios.save(u);
    }

    // CU2: Iniciar Sesión
    public void iniciarSesion(  
    String login, 
    String password
    ) throws ExcepcionUsuario {

        // (1) Sistema busca usuarios por el login
        List<Usuario> usuariosEncontrados = usuarios.findByCorreo(login);
    
        // (2) Cuando no se encuentra ningún usuario con ese login
        if (usuariosEncontrados.isEmpty()) {
            // 2.1. Sistema muestra un mensaje "No se encontró ningún usuario con ese login"
            // 2.2. Sistema termina
            throw new ExcepcionUsuario("No se encontró ningún usuario con ese login");
        }
    
        // (3) Validar que el password coincida con al menos uno de los usuarios encontrados
        Usuario usuarioEncontrado = usuariosEncontrados.get(0);

        // (4) Cuando el password no coincide con ningún usuario
        if (! usuarioEncontrado.getPassword().equals(password)) {
            // 4.1. Sistema muestra un mensaje "La contraseña no coincide"
            // 4.2. Sistema termina.
            throw new ExcepcionUsuario("La contraseña no coincide");
        }
        if(usuarioEncontrado.getSessionId()!= null){
            throw new ExcepcionUsuario("Esta sesion ya ha sido iniciada");
        }
    
        // (6) Sistema inicia la sesión para el usuario
        String sessionId = generarIdentificadorSesion();
        usuarioEncontrado.setSessionId(sessionId);

        usuarios.save(usuarioEncontrado);
    }

    public void cerrarSesion(
        String correo) throws ExcepcionUsuario {
        // (1) Verificar que el sessionId sea válido
        List<Usuario> usuariosEncontrados = usuarios.findByCorreo(correo);
    
        // (2) Cuando el sessionId no es válido
        if (usuariosEncontrados.isEmpty()) {
            // 2.1. Sistema muestra un mensaje "No se encontró ningún usuario con ese login"
            // 2.2. Sistema termina
            throw new ExcepcionUsuario("No se encontró ningún usuario con ese login");
        }
    
        Usuario usuarioEncontrado = usuariosEncontrados.get(0);
    
        if (usuarioEncontrado.getSessionId() == null) {
            throw new ExcepcionUsuario("La sesión no ha sido iniciada para este usuario");
        }
    
        // (6) Sistema inicia la sesión para el usuario
        usuarioEncontrado.setSessionId(null);
        usuarios.save(usuarioEncontrado);
    }


    private String generarIdentificadorSesion() {
        return UUID.randomUUID().toString();  // Genera un UUID (Universally Unique Identifier)
    }
}
