package com.biblioteca.controller;

import com.biblioteca.dtos.ReservaCubiculoDTO;
import com.biblioteca.service.ReservaCubiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservaCubiculoController {
    @Autowired
    private ReservaCubiculoService reservaCubiculoService;


    @GetMapping("reservasCubi")
    public ResponseEntity<List<ReservaCubiculoDTO>> listarReservasCubiculo(){
        return new ResponseEntity<>(reservaCubiculoService.listarReservaCubiculo(), HttpStatus.IM_USED);
    }

    @GetMapping("/reservasCubi/{reservacubiId}")
    public ResponseEntity<ReservaCubiculoDTO> obtenerReservaCubiculoPorID(@PathVariable("reservacubiId") long reservacubiId){
        return new ResponseEntity<>(reservaCubiculoService.obtenerReservaCubiculoPorId(reservacubiId), HttpStatus.OK);
    }

    @PostMapping("reservasCubi")
    public ResponseEntity<ReservaCubiculoDTO> registrarReservaCubiculo(@RequestBody ReservaCubiculoDTO reservaCubiculoDTO){
        return new ResponseEntity<>(reservaCubiculoService.registrarReservaCubiculo(reservaCubiculoDTO), HttpStatus.OK);
    }

    @PutMapping("reservasCubi")
    public ResponseEntity<ReservaCubiculoDTO> actualizarReservaCubiculo(@RequestBody ReservaCubiculoDTO reservaCubiculoDTO){
        return new ResponseEntity<>(reservaCubiculoService.actualizarReservaCubiculo(reservaCubiculoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/reservasCubi/{reservacubiId}")
    public ResponseEntity<ReservaCubiculoDTO> eliminarReservaCubiculo(@PathVariable("reservacubiId") long reservacubiId){
        return new ResponseEntity<>(reservaCubiculoService.eliminarReservaCubiculo(reservacubiId), HttpStatus.ACCEPTED);
    }

}
