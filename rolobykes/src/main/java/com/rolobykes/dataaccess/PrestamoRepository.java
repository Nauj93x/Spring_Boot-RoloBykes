package com.rolobykes.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Prestamo;



@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

    List<Prestamo> findByBicicleta(Bicicleta bicicleta);     
}
