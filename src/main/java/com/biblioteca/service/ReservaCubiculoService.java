package com.biblioteca.service;

import com.biblioteca.dtos.ReservaCubiculoDTO;

import java.util.List;

public interface ReservaCubiculoService {
    List<ReservaCubiculoDTO> listarReservaCubiculo();
    ReservaCubiculoDTO obtenerReservaCubiculoPorId(long id);
    ReservaCubiculoDTO registrarReservaCubiculo(ReservaCubiculoDTO reservaCubiculoDTO);
    ReservaCubiculoDTO actualizarReservaCubiculo(ReservaCubiculoDTO reservaCubiculoDTO);
    ReservaCubiculoDTO eliminarReservaCubiculo(long id);
}
