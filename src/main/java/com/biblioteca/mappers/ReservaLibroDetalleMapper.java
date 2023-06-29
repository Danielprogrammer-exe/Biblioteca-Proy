package com.biblioteca.mappers;

import com.biblioteca.dtos.ReservaLibroDTO;
import com.biblioteca.dtos.ReservaLibroDetalleDTO;
import com.biblioteca.model.ReservaLibro;
import com.biblioteca.model.ReservaLibroDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaLibroDetalleMapper {
    ReservaLibroDetalleMapper instancia = Mappers.getMapper(ReservaLibroDetalleMapper.class);

    ReservaLibroDetalleDTO reservaLibroDetalleAReservaLibroDetalleDTO(ReservaLibroDetalle reservaLibroDetalle);
    ReservaLibroDetalle reservaLibroDetalleDTOAReservaLibroDetalle(ReservaLibroDetalleDTO reservaLibroDetalleDTO);
    List<ReservaLibroDetalleDTO> listaReservaLibroDetalleAListaReservaLibroDetalleDTO(List<ReservaLibroDetalle> listaReservaLibroDetalle);
}
