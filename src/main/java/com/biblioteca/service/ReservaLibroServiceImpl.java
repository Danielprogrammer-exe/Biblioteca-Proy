package com.biblioteca.service;

import com.biblioteca.dtos.ReservaLibroDTO;
import com.biblioteca.dtos.ReservaLibroDetalleDTO;
import com.biblioteca.mappers.ReservaLibroDetalleMapper;
import com.biblioteca.mappers.ReservaLibroMapper;
import com.biblioteca.model.ReservaLibro;
import com.biblioteca.model.ReservaLibroDetalle;
import com.biblioteca.repository.ReservaLibroDetalleRepository;
import com.biblioteca.repository.ReservaLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaLibroServiceImpl implements ReservaLibroService{
    @Autowired
    private ReservaLibroRepository reservaLibroRepository;

    @Autowired
    private ReservaLibroDetalleRepository reservaLibroDetalleRepository;

    @Override
    public List<ReservaLibroDTO> listarReservaLibro() {
        List<ReservaLibroDTO> lista = ReservaLibroMapper.instancia.listaReservaLibroAListaReservaLibroDTO(reservaLibroRepository.findAll());
        for(int j=0; j<lista.size(); j++){
            lista.get(j).setReservaLibroDetalleDTO(
                    ReservaLibroDetalleMapper.instancia.listaReservaLibroDetalleAListaReservaLibroDetalleDTO(
                            reservaLibroDetalleRepository.getReservaLibroDetalleByReservaLibroId(lista.get(j).getId()))
            );
        }
        return lista;
    }

    @Override
    public ReservaLibroDTO obtenerReservaLibroPorId(long id) {
        Optional<ReservaLibro> reservaLibro = reservaLibroRepository.findById(id);
        ReservaLibroDTO reservaLibroDTO;
        if(reservaLibro.isPresent()){
            reservaLibroDTO = ReservaLibroMapper.instancia.reservaLibroAReservaLibroDTO(reservaLibro.get());
            reservaLibroDTO.setReservaLibroDetalleDTO(
                    ReservaLibroDetalleMapper.instancia.listaReservaLibroDetalleAListaReservaLibroDetalleDTO(
                            reservaLibroDetalleRepository.getReservaLibroDetalleByReservaLibroId(id)
                    )
            );
        }else{
            reservaLibroDTO = null;
        }
        return reservaLibroDTO;
    }

    @Override
    @Transactional
    public ReservaLibroDTO registrarReservaLibro(ReservaLibroDTO reservaLibroDTO) {
        ReservaLibro reservaLibro = ReservaLibroMapper.instancia.reservaLibroDTOAReservaLibro(reservaLibroDTO);
        ReservaLibro respuestaEntidad = reservaLibroRepository.save(reservaLibro);

        for(ReservaLibroDetalleDTO reservaLibroDetalleDTO : reservaLibroDTO.getReservaLibroDetalleDTO()){
            ReservaLibroDetalle rld = ReservaLibroDetalleMapper.instancia.reservaLibroDetalleDTOAReservaLibroDetalle(reservaLibroDetalleDTO);
            rld.setReservaLibro(respuestaEntidad);
            reservaLibroDetalleRepository.save(rld);
        }

        ReservaLibroDTO respuestaDTO = ReservaLibroMapper.instancia.reservaLibroAReservaLibroDTO(reservaLibroRepository.getById(respuestaEntidad.getId()));
        respuestaDTO.setReservaLibroDetalleDTO(
                ReservaLibroDetalleMapper.instancia.listaReservaLibroDetalleAListaReservaLibroDetalleDTO(reservaLibroDetalleRepository.getReservaLibroDetalleByReservaLibroId(respuestaEntidad.getId()))
        );
        return respuestaDTO;
    }

    @Override
    @Transactional
    public ReservaLibroDTO actualizarReservaLibro(ReservaLibroDTO reservaLibroDTO) {
        return registrarReservaLibro(reservaLibroDTO);
    }

    @Override
    @Transactional
    public ReservaLibroDTO eliminarReservaLibro(long id) {
        Optional<ReservaLibro> reservaLibro = reservaLibroRepository.findById(id);
        ReservaLibroDTO reservaLibroDTO;
        if(reservaLibro.isPresent()){
            reservaLibroDTO = ReservaLibroMapper.instancia.reservaLibroAReservaLibroDTO(reservaLibro.get());
            reservaLibroRepository.delete(reservaLibro.get());

        }else{
            reservaLibroDTO = null;
        }
        return reservaLibroDTO;
    }
}
