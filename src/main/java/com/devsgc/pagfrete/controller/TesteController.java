package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.model.Teste;
import com.devsgc.pagfrete.repository.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/testes")
public class TesteController {
/*
    private final TesteRepository testeTepository;

    @Autowired
    public TesteController(TesteRepository testeTepository) {
        this.testeTepository = testeTepository;
    }

 */


    @GetMapping
    public String listarTodos(){
        return "teste 123";
    }


/*
    @GetMapping
    public @ResponseBody Iterable<Teste> listarTodos(){
        return testeTepository.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> addTeste(@RequestBody Teste t){
        return new ResponseEntity<>(testeTepository.save(t), HttpStatus.OK);
    }

 */
}
