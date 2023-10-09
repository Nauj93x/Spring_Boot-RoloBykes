package com.rolobykes.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.UsuarioRepository;
import com.rolobykes.domain.Usuario;

@Service
public class LoginUseCase {
    
    @Autowired
    UsuarioRepository usuarios;

    // CU1: Logear Usuario
    public void logearUsuario (
        String correo,       // 1. Actor ingresa correo
        String password    // 3. Actor ingresa password
    ) throws UsuarioException {

        // 2. Sistema valida que exista un usuario con ese correo
        List<Usuario> usuariosExistentes = usuarios.findByCorreo(correo);

        // (2) Cuando la combinación de contraseña y correo no existe
        //Se quiere que compare la contraseña dada con la contraseña del usuario, con aquella del
        //usuario encontrado por medio del correo del usuario
        if (usuarios.findByCorreo(correo) == null || usuarios.findByCorreo(correo).getPassword == password) {
            // 2.1. Sistema muestra un mensaje "No "
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
