package com.biblioteca.repository;

import com.biblioteca.model.Cubiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CubiculoRepository extends JpaRepository<Cubiculo,Long> {
}
