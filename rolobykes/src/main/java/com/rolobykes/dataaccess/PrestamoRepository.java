package com.rolobykes.dataaccess;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolobykes.domain.Bicicleta;
import com.rolobykes.domain.Prestamo;
import java.util.List;


@Repository
public interface PrestamoRepository extends JpaRepository <Prestamo, String>{

    List<Prestamo> findByBicicleta(Bicicleta bicicleta);     
}
