package com.rolobykes.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Usuario;

@Service
public class RegisterUseCase {
    
    @Autowired
    UsuarioRepository usuarios;

    // CU1: Registrar Usuario
    public void registrarUsuario (
        String correo,       // 1. Actor ingresa correo
        String password,    // 3. Actor ingresa password
        String nombre       // 5. Actor ingresa nombre
    ) throws UsuarioException {

        // 2. Sistema valida que no exista otro usuario con ese login
        List<Usuario> usuariosExistentes = usuarios.findByCorreo(correo);

        // (2) Cuando existe otro usuario con ese login
        if (usuariosExistentes.size() > 0 ) {
            // 2.1. Sistema muestra un mensaje "Existe otro usuario con ese login"
            // 2.2. Sistema termina
            throw new UsuarioException("Existe otro usuario con ese login");
        }

        // 4. Sistema valida que el password tenga más de cinco letras 
        // (4) Cuando el password tiene menos de cinco letras
        if (password.trim().length() < 5) {
            // 4.1. Sistema muestra un mensaje "El password tiene menos de cinco letras"
            // 4.2. Sistema termina.
            throw new UsuarioException("El password tiene menos de cinco letras");
        }

        // 6. Sistema registra el usuario
        Usuario u = new Usuario();
        u.setCorreo(correo);
        u.setNombre(nombre);
        u.setPassword(password);

        usuarios.save(u);

    }


}