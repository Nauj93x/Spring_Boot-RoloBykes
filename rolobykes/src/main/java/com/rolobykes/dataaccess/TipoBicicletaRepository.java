package com.rolobykes.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolobykes.domain.TipoBicicleta;

public interface TipoBicicletaRepository extends JpaRepository<TipoBicicletaRepository, String>{
    List<TipoBicicleta> findByNombre(String nombre);
}
