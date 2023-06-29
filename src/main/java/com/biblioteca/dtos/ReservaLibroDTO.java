package com.biblioteca.dtos;

import com.biblioteca.model.ReservaLibroDetalle;
import com.biblioteca.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class ReservaLibroDTO {
    private Long id;
    private User usuario;
    private Date fecReserva;
    private Date fecDevolucion;
    private String observaciones;
    private List<ReservaLibroDetalleDTO> reservaLibroDetalleDTO;
}
