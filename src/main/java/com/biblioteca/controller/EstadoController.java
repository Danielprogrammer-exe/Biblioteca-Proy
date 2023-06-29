package com.biblioteca.controller;

import com.biblioteca.model.Estado;
import com.biblioteca.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/estados")
public class EstadoController {

    EstadoRepository stateRepository;

    @GetMapping
    public Iterable<Estado> list() {
        return this.stateRepository.findAll();
    }
}
