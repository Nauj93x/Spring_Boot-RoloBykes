package com.rolobykes.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository <Bicicleta, String>{
    List<Bicicleta> findByTipoBicicleta(String TipoBicicleta);
    List<Bicicleta> findByEstado(boolean Estado);
}
