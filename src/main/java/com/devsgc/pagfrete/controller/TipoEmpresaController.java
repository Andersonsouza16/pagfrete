package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.error.ResourceNotFoundException;
import com.devsgc.pagfrete.model.TipoEmpresa;
import com.devsgc.pagfrete.repository.TipoEmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "tipo_empresa")
public class TipoEmpresaController {
    private TipoEmpresaRepository tipoEmpresaRepository;

    public TipoEmpresaController(TipoEmpresaRepository tipoEmpresaRepository) {
        this.tipoEmpresaRepository = tipoEmpresaRepository;
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    Iterable<TipoEmpresa> listarTodos(){
        return this.tipoEmpresaRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTipoEmpresaById(@PathVariable("id") Long id){
        if(tipoEmpresaRepository.findById(id).isPresent()){
            TipoEmpresa tipoEmpresa = tipoEmpresaRepository.findById(id).get();
            return new ResponseEntity<>(tipoEmpresa, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Nenhum Tipo Empresa com id: " + id);
    }


    @CrossOrigin
    @PostMapping
    public @ResponseBody ResponseEntity<?> salvar(@RequestBody TipoEmpresa tipoEmpresa){
        return new ResponseEntity<>(tipoEmpresaRepository.save(tipoEmpresa), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping
    public @ResponseBody ResponseEntity<?> atualizar(@RequestBody TipoEmpresa tipoEmpresa){
        return new ResponseEntity<>(tipoEmpresaRepository.save(tipoEmpresa), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<?> deletar(@PathVariable("id") Long id){
        tipoEmpresaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
