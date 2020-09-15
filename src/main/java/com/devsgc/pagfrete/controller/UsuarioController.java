package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.error.ResourceNotFoundException;
import com.devsgc.pagfrete.model.Usuario;
import com.devsgc.pagfrete.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.ls.LSOutput;

import javax.swing.text.html.parser.Entity;
import javax.xml.bind.SchemaOutputResolver;
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
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") int id){
            if (!usuarioRepository.findById(id).isPresent()) {
                throw new ResourceNotFoundException("Nenhum usuaŕio encontrado com id: " + id);
            }
            Usuario usuario = usuarioRepository.findById(id).get();
            return new ResponseEntity<>(usuario, HttpStatus.OK);
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
    //@PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> deletar(@PathVariable("id") int id){
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
