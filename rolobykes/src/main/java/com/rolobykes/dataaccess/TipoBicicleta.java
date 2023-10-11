package com.rolobykes.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoBicicleta extends JpaRepository<TipoBicicleta, String>{
    List<TipoBicicleta> findByNombre(String nombre);
}
