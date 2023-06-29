package com.biblioteca.service;

import com.biblioteca.dtos.ReservaCubiculoDTO;
import com.biblioteca.dtos.ReservaCubiculoDetalleDTO;
import com.biblioteca.mappers.ReservaCubiculoDetalleMapper;
import com.biblioteca.mappers.ReservaCubiculoMapper;
import com.biblioteca.model.ReservaCubiculo;
import com.biblioteca.model.ReservaCubiculoDetalle;
import com.biblioteca.repository.ReservaCubiculoDetalleRepository;
import com.biblioteca.repository.ReservaCubiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaCubiculoServiceImpl implements ReservaCubiculoService{
    @Autowired
    private ReservaCubiculoRepository reservaCubiculoRepository;

    @Autowired
    private ReservaCubiculoDetalleRepository reservaCubiculoDetalleRepository;
    @Override
    public List<ReservaCubiculoDTO> listarReservaCubiculo() {
        List<ReservaCubiculoDTO> lista = ReservaCubiculoMapper.instancia.listaReservaCubiculoAListaReservaCubiculoDTO(reservaCubiculoRepository.findAll());
        for(int j=0; j<lista.size(); j++){
            lista.get(j).setReservaCubiculoDetalleDTO(
                    ReservaCubiculoDetalleMapper.instancia.listaReservaCubiculoDetalleAListaReservaCubiculoDetalleDTO(
                            reservaCubiculoDetalleRepository.getReservaCubiculoDetalleByReservaCubiculoId(lista.get(j).getId())
                    )
            );
        }
        return lista;
    }

    @Override
    public ReservaCubiculoDTO obtenerReservaCubiculoPorId(long id) {
        Optional<ReservaCubiculo> reservaCubiculo = reservaCubiculoRepository.findById(id);
        ReservaCubiculoDTO reservaCubiculoDTO;
        if(reservaCubiculo.isPresent()){
            reservaCubiculoDTO = ReservaCubiculoMapper.instancia.reservaCubiculoAReservaCubiculoDTO(reservaCubiculo.get());
            reservaCubiculoDTO.setReservaCubiculoDetalleDTO(
                    ReservaCubiculoDetalleMapper.instancia.listaReservaCubiculoDetalleAListaReservaCubiculoDetalleDTO(reservaCubiculoDetalleRepository.getReservaCubiculoDetalleByReservaCubiculoId(id))
            );
        }else{
            reservaCubiculoDTO = null;
        }
        return reservaCubiculoDTO;
    }

    @Override
    @Transactional
    public ReservaCubiculoDTO registrarReservaCubiculo(ReservaCubiculoDTO reservaCubiculoDTO) {
        ReservaCubiculo reservaCubiculo = ReservaCubiculoMapper.instancia.reservaCubiculoDTOAReservaCubiculo(reservaCubiculoDTO);
        ReservaCubiculo respuestaEntidad = reservaCubiculoRepository.save(reservaCubiculo);

        for(ReservaCubiculoDetalleDTO reservaCubiculoDetalleDTO : reservaCubiculoDTO.getReservaCubiculoDetalleDTO()){
            ReservaCubiculoDetalle rcd = ReservaCubiculoDetalleMapper.instancia.reservaCubiculoDetalleDTOAReservaCubiculoDetalle(reservaCubiculoDetalleDTO);
            rcd.setReservaCubiculo(respuestaEntidad);
            reservaCubiculoDetalleRepository.save(rcd);
        }

        ReservaCubiculoDTO respuestaDTO = ReservaCubiculoMapper.instancia.reservaCubiculoAReservaCubiculoDTO(reservaCubiculoRepository.getById(respuestaEntidad.getId()));
        respuestaDTO.setReservaCubiculoDetalleDTO(
                ReservaCubiculoDetalleMapper.instancia.listaReservaCubiculoDetalleAListaReservaCubiculoDetalleDTO(reservaCubiculoDetalleRepository.getReservaCubiculoDetalleByReservaCubiculoId(respuestaEntidad.getId()))
        );

        return respuestaDTO;
    }

    @Override
    @Transactional
    public ReservaCubiculoDTO actualizarReservaCubiculo(ReservaCubiculoDTO reservaCubiculoDTO) {
        return registrarReservaCubiculo(reservaCubiculoDTO);
    }

    @Override
    @Transactional
    public ReservaCubiculoDTO eliminarReservaCubiculo(long id) {
        Optional<ReservaCubiculo> reservaCubiculo = reservaCubiculoRepository.findById(id);
        ReservaCubiculoDTO reservaCubiculoDTO;
        if(reservaCubiculo.isPresent()){
            reservaCubiculoDTO = ReservaCubiculoMapper.instancia.reservaCubiculoAReservaCubiculoDTO(reservaCubiculo.get());
            reservaCubiculoRepository.delete(reservaCubiculo.get());
        }else{
            reservaCubiculoDTO = null;
        }
        return reservaCubiculoDTO;
    }
}
