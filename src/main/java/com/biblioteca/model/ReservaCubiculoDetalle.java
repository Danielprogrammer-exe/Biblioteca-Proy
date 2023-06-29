package com.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "tb_reserva_cubiculo_detalle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaCubiculoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservacubideta;

    @Column(name = "importe", nullable = false)
    private BigDecimal importe;

    @Column(name="horas", nullable = false)
    private Integer horas;

    @OneToOne()
    @JoinColumn(name="id_cubiculo")
    private Cubiculo cubiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservacubiculo")
    private ReservaCubiculo reservaCubiculo;
}
