package com.biblioteca.mappers;

import com.biblioteca.dtos.CubiculoCreateDTO;
import com.biblioteca.dtos.CubiculoDTO;
import com.biblioteca.dtos.CubiculoUpdateDTO;
import com.biblioteca.model.Cubiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CubiculoMapper {

    CubiculoMapper instancia = Mappers.getMapper(CubiculoMapper.class);
    CubiculoDTO cubiculoACubiculoDTO(Cubiculo cubiculo);
    Cubiculo cubiculoDTOACubiculo(CubiculoDTO cubiculoDTO);

    //methods
    Cubiculo cubiculoCreateDTOACubiculo(CubiculoCreateDTO cubiculoCreateDTO);
    Cubiculo cubiculoUpdateDTOACubiculo(CubiculoUpdateDTO cubiculoUpdateDTO);

    List<CubiculoDTO> listaCubiculoAListaCubiculoDTO(List<Cubiculo> listaCubiculo);

}
