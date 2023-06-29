package com.biblioteca.controller;

import com.biblioteca.dtos.LibroCreateDTO;
import com.biblioteca.dtos.LibroDTO;
import com.biblioteca.dtos.LibroUpdateDTO;
import com.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("libros")
    public ResponseEntity<List<LibroDTO>> listarLibros(){
        return new ResponseEntity<>(libroService.listarLibros(), HttpStatus.OK);
    }

    @GetMapping("/libros/{libroId}")
    public ResponseEntity<LibroDTO> obtenerLibroXId(@PathVariable("libroId") long libroId){
        return new ResponseEntity<>(libroService.obtenerLibroxID(libroId),HttpStatus.OK);
    }

    @PostMapping("libros")
    public ResponseEntity<LibroDTO> registrarLibro(@RequestBody LibroCreateDTO libroCreateDTO){
        return new ResponseEntity<>(libroService.registrarLibro(libroCreateDTO), HttpStatus.OK);
    }

    @PutMapping("libros")
    public ResponseEntity<LibroDTO> actualizarLibro(@RequestBody LibroUpdateDTO libroUpdateDTO){
        return new ResponseEntity<>(libroService.actualizarLibro(libroUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/libros/{libroId}")
    public ResponseEntity<String> eliminarLibro(@PathVariable("libroId") long libroId) {
        return new ResponseEntity<>(libroService.eliminarLibro(libroId), HttpStatus.OK);
    }

}
