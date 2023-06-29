package com.biblioteca.mappers;

import com.biblioteca.dtos.ReservaCubiculoDTO;
import com.biblioteca.dtos.ReservaLibroDTO;
import com.biblioteca.model.ReservaCubiculo;
import com.biblioteca.model.ReservaLibro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaLibroMapper {
    ReservaLibroMapper instancia = Mappers.getMapper(ReservaLibroMapper.class);

    ReservaLibroDTO reservaLibroAReservaLibroDTO(ReservaLibro reservaLibro);
    ReservaLibro reservaLibroDTOAReservaLibro(ReservaLibroDTO reservaLibroDTO);
    List<ReservaLibroDTO> listaReservaLibroAListaReservaLibroDTO(List<ReservaLibro> listaReservaLibro);
}
