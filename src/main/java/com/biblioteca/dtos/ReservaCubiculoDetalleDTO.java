package com.biblioteca.dtos;

import com.biblioteca.model.Cubiculo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ReservaCubiculoDetalleDTO {
    private Long id_reservacubideta;
    private BigDecimal importe;
    private Integer horas;
    private Cubiculo cubiculo;
}
