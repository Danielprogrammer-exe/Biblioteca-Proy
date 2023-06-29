package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_reserva_libro_detalle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaLibroDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservalibrodeta;

    @Column(name = "importe", nullable = false)
    private BigDecimal importe;

    @OneToOne()
    @JoinColumn(name="id_libro")
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservalibro")
    private ReservaLibro reservaLibro;

}
