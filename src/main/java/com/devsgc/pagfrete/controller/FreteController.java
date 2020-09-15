package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.model.Frete;
import com.devsgc.pagfrete.repository.FreteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frete")
public class FreteController{

    final FreteRepository freteRepository;

    public FreteController(FreteRepository freteRepository){
        this.freteRepository = freteRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Frete> listarTodos(){
        return freteRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody ResponseEntity<?> salvar(@RequestBody Frete frete){
        return new ResponseEntity<>(freteRepository.save(frete), HttpStatus.CREATED);
    }
}
