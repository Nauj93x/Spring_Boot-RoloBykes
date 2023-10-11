package com.rolobykes.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, String>{
    
}
