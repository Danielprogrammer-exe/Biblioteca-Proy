package com.biblioteca.repository;

import com.biblioteca.model.ReservaLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaLibroRepository extends JpaRepository<ReservaLibro, Long> {
}
