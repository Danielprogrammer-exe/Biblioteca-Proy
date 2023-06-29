package com.biblioteca.repository;

import com.biblioteca.model.ReservaCubiculoDetalle;
import com.biblioteca.model.ReservaLibroDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaLibroDetalleRepository extends JpaRepository<ReservaLibroDetalle, Long> {
    public List<ReservaLibroDetalle> getReservaLibroDetalleByReservaLibroId(Long id);
}
