package com.biblioteca.dtos;

import com.biblioteca.model.Estado;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LibroCreateDTO {
    private String titulo;
    private String nombreAutor;
    private String nombreEditorial;
    private Integer numPaginas;
    private Integer stock;
    private BigDecimal precioLibro;
    private Estado estado;
}
