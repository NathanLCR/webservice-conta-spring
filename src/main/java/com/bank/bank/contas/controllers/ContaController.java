package com.bank.bank.contas.controllers;

import com.bank.bank.contas.entities.Conta;
import com.bank.bank.contas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/conta")
@RestController
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping()
    public Iterable<Conta> getAll(){

        return contaRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Conta conta){
        if (conta.getTitular() != null){
            contaRepository.save(conta);
        }else{
            return new ResponseEntity<>("Dados invalidos",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody Conta newConta){
        Optional<Conta> conta = contaRepository.findById(newConta.getId());

        if(conta)
    }

    @DeleteMapping()
    public ResponseEntity delete(){

    }

}
