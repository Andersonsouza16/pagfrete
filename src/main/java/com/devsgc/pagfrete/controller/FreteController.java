package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.model.Frete;
import com.devsgc.pagfrete.repository.FreteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
