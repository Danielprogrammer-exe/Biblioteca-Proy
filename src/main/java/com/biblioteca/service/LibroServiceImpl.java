package com.biblioteca.service;

import com.biblioteca.dtos.LibroCreateDTO;
import com.biblioteca.dtos.LibroDTO;
import com.biblioteca.dtos.LibroUpdateDTO;
import com.biblioteca.mappers.LibroMapper;
import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<LibroDTO> listarLibros() {
        return LibroMapper.instancia.listaLibroAListaLibroDTO(libroRepository.findAll());
    }

    @Override
    public LibroDTO obtenerLibroxID(long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        LibroDTO libroDTO;

        if (libro.isPresent()) {
            libroDTO = LibroMapper.instancia.libroALibroDTO(libro.get());
        } else {libroDTO = null;}

        return libroDTO;
    }

    @Override
    public LibroDTO registrarLibro(LibroCreateDTO libroCreateDTO) {
        Libro libro = LibroMapper.instancia.libroCreateDTOALibro(libroCreateDTO);
        Libro respuestaEntity = libroRepository.save(libro);
        LibroDTO respuestaDTO = LibroMapper.instancia.libroALibroDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public LibroDTO actualizarLibro(LibroUpdateDTO libroUpdateDTO) {
        Libro libro = LibroMapper.instancia.libroUpdateDTOALibro(libroUpdateDTO);
        Libro respuestaEntity = libroRepository.save(libro);
        LibroDTO respuestaDTO = LibroMapper.instancia.libroALibroDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarLibro(long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        String resultado;

        if (libroOptional.isPresent()) {
            libroRepository.delete(libroOptional.get());
            resultado = "Registro eliminado exitosamente";
        } else {
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }

}
