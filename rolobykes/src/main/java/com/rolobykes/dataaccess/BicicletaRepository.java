package com.rolobykes.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.TipoBicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository <Bicicleta, String>{

    List<Bicicleta> findByTipo(TipoBicicleta tipo);

    List<Bicicleta> findByDisponible(boolean disponible);
}
