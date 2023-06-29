package com.biblioteca.service;

import com.biblioteca.dtos.CubiculoCreateDTO;
import com.biblioteca.dtos.CubiculoDTO;
import com.biblioteca.dtos.CubiculoUpdateDTO;
import com.biblioteca.mappers.CubiculoMapper;
import com.biblioteca.model.Cubiculo;
import com.biblioteca.repository.CubiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CubiculoServiceImp implements CubiculoService{

    @Autowired
    private CubiculoRepository cubiculoRepository;

    @Override
    public List<CubiculoDTO> listarCubiculos() {
        return CubiculoMapper.instancia.listaCubiculoAListaCubiculoDTO( cubiculoRepository.findAll());
    }

    @Override
    public CubiculoDTO obtenerCubiculoXID(long id) {
        Optional<Cubiculo> cubiculo = cubiculoRepository.findById(id);
        CubiculoDTO cubiculoDTO;
        if(cubiculo.isPresent()){
            cubiculoDTO = CubiculoMapper.instancia.cubiculoACubiculoDTO(cubiculo.get());
        } else {
            cubiculoDTO = null;
        }
        return cubiculoDTO;
    }

    @Override
    public CubiculoDTO registarCubiculo(CubiculoCreateDTO cubiculoCreateDTO) {

        Cubiculo cubiculo = CubiculoMapper.instancia.cubiculoCreateDTOACubiculo( cubiculoCreateDTO );
        Cubiculo respuestaEntity = cubiculoRepository.save(cubiculo);
        CubiculoDTO respuestaDTO = CubiculoMapper.instancia.cubiculoACubiculoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public CubiculoDTO updateCubiculo(CubiculoUpdateDTO cubiculoUpdateDTO) {
        Cubiculo cubiculo = CubiculoMapper.instancia.cubiculoUpdateDTOACubiculo( cubiculoUpdateDTO );
        Cubiculo respuestaEntity = cubiculoRepository.save(cubiculo);
        CubiculoDTO respuestaDTO = CubiculoMapper.instancia.cubiculoACubiculoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarCubiculo(long id) {
        Optional<Cubiculo> cubiculo = cubiculoRepository.findById(id);
        String resultado;
        if(cubiculo.isPresent()){
            cubiculoRepository.delete(cubiculo.get());
            resultado="Cubículo Eliminado";
        }else {
            resultado="No se pudo eliminar el cubículo";
        }
        return resultado;
    }
}
