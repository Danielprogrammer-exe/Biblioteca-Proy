package com.biblioteca.service;

import com.biblioteca.dtos.CubiculoCreateDTO;
import com.biblioteca.dtos.CubiculoDTO;
import com.biblioteca.dtos.CubiculoUpdateDTO;

import java.util.List;

public interface CubiculoService {

    List<CubiculoDTO> listarCubiculos();
    CubiculoDTO obtenerCubiculoXID(long id);
    CubiculoDTO registarCubiculo(CubiculoCreateDTO cubiculoCreateDTO);

    CubiculoDTO updateCubiculo(CubiculoUpdateDTO cubiculoUpdateDTO);

    String eliminarCubiculo(long id);


}
