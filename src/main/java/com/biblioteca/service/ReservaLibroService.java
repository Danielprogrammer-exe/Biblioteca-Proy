package com.biblioteca.service;

import com.biblioteca.dtos.ReservaLibroDTO;

import java.util.List;

public interface ReservaLibroService {
    List<ReservaLibroDTO> listarReservaLibro();
    ReservaLibroDTO obtenerReservaLibroPorId(long id);
    ReservaLibroDTO registrarReservaLibro(ReservaLibroDTO reservaLibroDTO);
    ReservaLibroDTO actualizarReservaLibro(ReservaLibroDTO reservaLibroDTO);
    ReservaLibroDTO eliminarReservaLibro(long id);
}
