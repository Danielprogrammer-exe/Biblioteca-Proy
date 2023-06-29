package com.biblioteca.repository;

import com.biblioteca.model.ReservaCubiculoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaCubiculoDetalleRepository extends JpaRepository<ReservaCubiculoDetalle, Long> {
    public List<ReservaCubiculoDetalle> getReservaCubiculoDetalleByReservaCubiculoId(Long id);

}
