package com.biblioteca.controller;

import com.biblioteca.dtos.ReservaLibroDTO;

import com.biblioteca.service.ReservaLibroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservaLibroController {
    @Autowired
    private ReservaLibroService reservaLibroService;

    @GetMapping("reservaslibro")
    public ResponseEntity<List<ReservaLibroDTO>> listarReservasLibro(){
        return new ResponseEntity<>(reservaLibroService.listarReservaLibro(), HttpStatus.IM_USED);
    }

    @GetMapping("/reservaslibro/{reservalibroId}")
    public ResponseEntity<ReservaLibroDTO> obtenerReservaLibroPorID(@PathVariable("reservalibroId") long reservalibroId){
        return new ResponseEntity<>(reservaLibroService.obtenerReservaLibroPorId(reservalibroId), HttpStatus.OK);
    }

    @PostMapping("reservaslibro")
    public ResponseEntity<ReservaLibroDTO> registrarReservaLibro(@RequestBody ReservaLibroDTO reservaLibroDTO){
        return new ResponseEntity<>(reservaLibroService.registrarReservaLibro(reservaLibroDTO), HttpStatus.OK);
    }

    @PutMapping ("reservaslibro")
    public ResponseEntity<ReservaLibroDTO> actualizarReservaLibro(@RequestBody ReservaLibroDTO reservaLibroDTO){
        return new ResponseEntity<>(reservaLibroService.actualizarReservaLibro(reservaLibroDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/reservaslibro/{reservalibroId}")
    public ResponseEntity<ReservaLibroDTO> eliminarReservaLibroPorID(@PathVariable("reservalibroId") long reservalibroId){
        return new ResponseEntity<>(reservaLibroService.eliminarReservaLibro(reservalibroId), HttpStatus.ACCEPTED);
    }

}
