package com.rolobykes.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Usuario;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // el crea automáticamente
    //  - save
    //  - findAll
    //  - findById
    
    List<Usuario> findByCorreo(String correo);
    List<Usuario> findByPassword(String password);

}
