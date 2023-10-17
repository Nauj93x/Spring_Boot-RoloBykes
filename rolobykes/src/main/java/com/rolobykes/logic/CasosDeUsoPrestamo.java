package com.rolobykes.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolobykes.dataaccess.BicicletaRepository;
import com.rolobykes.dataaccess.PrestamoRepository;
import com.rolobykes.domain.Prestamo;
import com.rolobykes.domain.TipoBicicleta;
import com.rolobykes.domain.Usuario;

@Service
public class CasosDeUsoPrestamo {

    @Autowired
    PrestamoRepository prestamos;

    @Autowired
    BicicletaRepository bicicletas;

    public void PrestarBicicleta(Usuario Usuario,TipoBicicleta tipo) throws ExcepcionPrestamo {
        
        Prestamo prestamo = new Prestamo();

        if (Usuario.getSessionId() == null) {
            // 2.1. Sistema muestra un mensaje "El usuario no ha iniciado sesion"
            // 2.2. Sistema termina
            throw new ExcepcionPrestamo("El usuario no ha iniciado sesion");
        } else {

            // 2.1. Sistema muestra un mensaje "El usuario ha iniciado sesion"
            echo "<div class='alert alert-success'>El usuario ha iniciado sesion</div>";

            // 2.2. Sistema continúa con el prestamo
            prestamo.setUsuario(Usuario);
            prestamo.setActivo(true);

            boolean Estado = true;
            List<Bicicleta> bici = bicicletas.findByTipoBicicleta(tipo);
        }
    }
}
