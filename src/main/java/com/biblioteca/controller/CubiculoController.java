package com.biblioteca.controller;

import com.biblioteca.dtos.CubiculoCreateDTO;
import com.biblioteca.dtos.CubiculoDTO;
import com.biblioteca.dtos.CubiculoUpdateDTO;
import com.biblioteca.service.CubiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CubiculoController {

    @Autowired
    private CubiculoService cubiculoService;

    @GetMapping("cubiculos")
    public ResponseEntity<List<CubiculoDTO>> listarCubiculos(){
        return new ResponseEntity<>(cubiculoService.listarCubiculos(), HttpStatus.OK);
    }

    @GetMapping("/cubiculos/{cubiculoId}")
    public ResponseEntity<CubiculoDTO> obtenerCubiculoXID(@PathVariable("cubiculoId") long cubiculoId){
        return new ResponseEntity<>(cubiculoService.obtenerCubiculoXID(cubiculoId),HttpStatus.OK);
    }

    @PostMapping("cubiculos")
    public ResponseEntity<CubiculoDTO> registarCubiculos(@RequestBody CubiculoCreateDTO cubiculoCreateDTO){
        return new ResponseEntity<>(cubiculoService.registarCubiculo(cubiculoCreateDTO),HttpStatus.OK);
    }

    @PutMapping("cubiculos")
    public ResponseEntity<CubiculoDTO> actualizarCubiculos(@RequestBody CubiculoUpdateDTO cubiculoUpdateDTO){
        return new ResponseEntity<>(cubiculoService.updateCubiculo(cubiculoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/cubiculos/{cubiculoId}")
    public ResponseEntity<String> eliminarCubiculo(@PathVariable("cubiculoId") long cubiculoId){
        return new ResponseEntity<>(cubiculoService.eliminarCubiculo(cubiculoId),HttpStatus.OK);
    }

}
