package com.biblioteca.repository;

import com.biblioteca.model.ReservaCubiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaCubiculoRepository extends JpaRepository<ReservaCubiculo, Long> {

}
