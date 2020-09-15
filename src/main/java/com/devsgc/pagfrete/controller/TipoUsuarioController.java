package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.error.ResourceNotFoundException;
import com.devsgc.pagfrete.model.TipoUsuario;
import com.devsgc.pagfrete.repository.TipoUsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/tipo_usuario")
public class TipoUsuarioController {

    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioController(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody Iterable<TipoUsuario> listarTodos(){
        return this.tipoUsuarioRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTipoUsuarioById(@PathVariable("id") Long id){
        if(tipoUsuarioRepository.findById(id).isPresent()){
            TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id).get();
            return new ResponseEntity<>(tipoUsuario, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Nenhum TipoUsuario com id: " + id);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody ResponseEntity<?> salvar(@RequestBody TipoUsuario tipoUsuario){
        return new ResponseEntity<>(tipoUsuarioRepository.save(tipoUsuario), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping
    public @ResponseBody ResponseEntity<?> atualizar(@RequestBody TipoUsuario tipoUsuario){
        return new ResponseEntity<>(tipoUsuarioRepository.save(tipoUsuario), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<?> deletar(@PathVariable("id") Long id){
        tipoUsuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
