package com.biblioteca.dtos;

import com.biblioteca.model.Estado;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CubiculoCreateDTO {

    private String numCubi;
    private String observaciones;
    private Integer capacidad;
    private BigDecimal precioCubi;
    private Estado estado;

}
