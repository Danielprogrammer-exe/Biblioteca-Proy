package com.biblioteca.dtos;

import com.biblioteca.model.Estado;
import com.biblioteca.model.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReservaCubiculoDTO {
    private Long id;
    private Date fecReserva;
    private Estado estado;
    private User usuario;
    private List<ReservaCubiculoDetalleDTO> reservaCubiculoDetalleDTO;
}
