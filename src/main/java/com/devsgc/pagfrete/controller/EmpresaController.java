package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.error.ResourceNotFoundException;
import com.devsgc.pagfrete.model.Empresa;
import com.devsgc.pagfrete.model.TipoEmpresa;
import com.devsgc.pagfrete.repository.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "empresa")
public class EmpresaController {

    private EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    Iterable<Empresa> listarTodos(){
        return this.empresaRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTipoEmpresaById(@PathVariable("id") Long id){
        if(empresaRepository.findById(id).isPresent()){
            Empresa empresa = empresaRepository.findById(id).get();
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não encontrada empresa com id: " + id);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody ResponseEntity<?> salvar(@RequestBody Empresa empresa){
        return new ResponseEntity<>(empresaRepository.save(empresa), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping
    public @ResponseBody ResponseEntity<?> atualizar(@RequestBody Empresa empresa){
        return new ResponseEntity<>(empresaRepository.save(empresa), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<?> deletar(@PathVariable("id") Long id){
        empresaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
