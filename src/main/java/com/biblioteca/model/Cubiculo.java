package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cubiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cubiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cubiculo")
    private Long id;

    @Column(length = 30, nullable = false)
    private String numCubi;

    @Column(length = 500, nullable = false)
    private String observaciones;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false)
    private BigDecimal precioCubi;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;



}
