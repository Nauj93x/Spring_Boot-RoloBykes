package com.rolobykes.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.TipoBicicleta;

@Repository
public interface TipoBicicletaRepository extends JpaRepository<TipoBicicleta, String>{

    List<TipoBicicleta> findByNombre(String nombre);
}
