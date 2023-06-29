package com.biblioteca.mappers;

import com.biblioteca.dtos.ReservaCubiculoDTO;
import com.biblioteca.dtos.ReservaCubiculoDetalleDTO;
import com.biblioteca.model.ReservaCubiculoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaCubiculoDetalleMapper {
    ReservaCubiculoDetalleMapper instancia = Mappers.getMapper(ReservaCubiculoDetalleMapper.class);

    ReservaCubiculoDetalleDTO reservaCubiculoDetalleAReservaCubiculoDetalleDTO(ReservaCubiculoDetalle reservaCubiculoDetalle);
    ReservaCubiculoDetalle reservaCubiculoDetalleDTOAReservaCubiculoDetalle(ReservaCubiculoDetalleDTO reservaCubiculoDetalleDTO);
    List<ReservaCubiculoDetalleDTO> listaReservaCubiculoDetalleAListaReservaCubiculoDetalleDTO(List<ReservaCubiculoDetalle> listaReservaCubiculoDetalle);
}
