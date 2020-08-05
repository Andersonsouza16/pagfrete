package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.model.Usuario;
import com.devsgc.pagfrete.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody Iterable<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody ResponseEntity<?> salvar(@RequestBody Usuario usuario){

        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping
    public @ResponseBody ResponseEntity<?> atualizar(@RequestBody Usuario usuario){

        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deletar(@PathVariable("id") int id){
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
