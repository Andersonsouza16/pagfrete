package com.devsgc.pagfrete.controller;

import com.devsgc.pagfrete.model.Cliente;
import com.devsgc.pagfrete.model.Endereco;
import com.devsgc.pagfrete.repository.ClienteRepository;
import com.devsgc.pagfrete.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository){
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> add(@RequestBody Cliente cli){
        /*
        Endereco endereco = new Endereco();
        Endereco enderecoSalvo = enderecoRepository.save(cli.getEndereco());

        cli.setEndereco(enderecoSalvo);

         */
        cli.setDataInclusao(new java.sql.Date(System.currentTimeMillis()));
        return new ResponseEntity<>(clienteRepository.save(cli), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deletar(@PathVariable("id") int id){
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
