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

        if (Usuario.getSessionId() == null) {
            throw new ExcepcionPrestamo("El usuario no ha iniciado sesion");
        }

        List<Bicicleta> bicicletas = bicicletas.findByTipoBicicleta(tipo);

        if (bicicletas.isEmpty()) {
            throw new ExcepcionPrestamo("La bicicleta no está disponible");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(Usuario);
        prestamo.setTipoBicicleta(tipo);
        prestamo.setFechaInicio(new Date());
        prestamo.setFechaFin(new Date());

        bicicletas.get(0).setEstado("La bicicleta se encuentra prestada");

        prestamos.save(prestamo);
        bicicletas.save(bicicletas.get(0));
    }
}
