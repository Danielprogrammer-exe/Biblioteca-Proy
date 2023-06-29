package com.biblioteca.mappers;

import com.biblioteca.dtos.ReservaCubiculoDTO;
import com.biblioteca.model.ReservaCubiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaCubiculoMapper {
    ReservaCubiculoMapper instancia = Mappers.getMapper(ReservaCubiculoMapper.class);

    ReservaCubiculoDTO reservaCubiculoAReservaCubiculoDTO(ReservaCubiculo reservaCubiculo);
    ReservaCubiculo reservaCubiculoDTOAReservaCubiculo(ReservaCubiculoDTO reservaCubiculoDTO);
    List<ReservaCubiculoDTO> listaReservaCubiculoAListaReservaCubiculoDTO(List<ReservaCubiculo> listaReservaCubiculo);

}
