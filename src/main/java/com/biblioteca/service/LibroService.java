package com.biblioteca.service;

import com.biblioteca.dtos.LibroCreateDTO;
import com.biblioteca.dtos.LibroDTO;
import com.biblioteca.dtos.LibroUpdateDTO;

import java.util.List;

public interface LibroService {
    List<LibroDTO> listarLibros();
    LibroDTO obtenerLibroxID(long id);
    LibroDTO registrarLibro(LibroCreateDTO libroCreateDTO);
    LibroDTO actualizarLibro(LibroUpdateDTO libroUpdateDTO);
    String eliminarLibro(long id);
}
