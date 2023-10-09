package com.rolobykes.dataaccess;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository <Prestamo, String>{


    
}
