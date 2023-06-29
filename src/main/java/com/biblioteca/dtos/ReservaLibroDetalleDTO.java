package com.biblioteca.dtos;

import com.biblioteca.model.Libro;
import com.biblioteca.model.ReservaLibro;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReservaLibroDetalleDTO {
    private Long id_reservalibrodeta;
    private BigDecimal importe;
    private Libro libro;
}
