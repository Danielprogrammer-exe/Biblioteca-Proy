package com.biblioteca.mappers;

import com.biblioteca.dtos.LibroCreateDTO;
import com.biblioteca.dtos.LibroDTO;
import com.biblioteca.dtos.LibroUpdateDTO;
import com.biblioteca.model.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LibroMapper {
    LibroMapper instancia = Mappers.getMapper(LibroMapper.class);

    LibroDTO libroALibroDTO(Libro libro);
    Libro libroDTOALibro(LibroDTO libroDTO);
    Libro libroCreateDTOALibro(LibroCreateDTO libroCreateDTO);
    Libro libroUpdateDTOALibro(LibroUpdateDTO libroUpdateDTO);
    List<LibroDTO> listaLibroAListaLibroDTO(List<Libro> listaLibro);
}
