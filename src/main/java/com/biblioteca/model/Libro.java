package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    @Column(length = 45, nullable = false)
    private String titulo;

    @Column(length = 100, nullable = false)
    private String nombreAutor;

    @Column(length = 45, nullable = false)
    private String nombreEditorial;

    @Column(nullable = false)
    private Integer numPaginas;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private BigDecimal precioLibro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

}
