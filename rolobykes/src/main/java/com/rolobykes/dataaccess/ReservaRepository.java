package com.rolobykes.dataaccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Long>{
    
    List<Reserva> findByFechaReserva(Date fechaReserva);
}
