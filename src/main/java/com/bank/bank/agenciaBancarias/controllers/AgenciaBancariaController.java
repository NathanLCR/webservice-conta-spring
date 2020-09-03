package com.bank.bank.agenciaBancarias.controllers;


import com.bank.bank.agenciaBancarias.entities.AgenciaBancaria;
import com.bank.bank.agenciaBancarias.repositories.AgenciaBancariaRepository;
import com.bank.bank.contas.entities.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/agenciabancaria")
@RestController
public class AgenciaBancariaController {

    @Autowired
    private AgenciaBancariaRepository agenciaBancariaRepository;

    @GetMapping()
    public Iterable<AgenciaBancaria> getAll(){
        return agenciaBancariaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id){

        Optional<AgenciaBancaria> agenciaBancaria = agenciaBancariaRepository.findById(id);


        if (agenciaBancaria.isEmpty()){
            return new ResponseEntity<>("Agencia não encontrada",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(agenciaBancaria,HttpStatus.FOUND);
    }
    @PostMapping()
    public ResponseEntity create(@RequestBody AgenciaBancaria agencia){
        if (agencia.getNomeAgencia() != null){
            agenciaBancariaRepository.save(agencia);
        }else{
            return new ResponseEntity<>("Dados invalidos", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody AgenciaBancaria newAgencia){
        Optional<AgenciaBancaria> agencia = agenciaBancariaRepository.findById(newAgencia.getId());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){

        agenciaBancariaRepository.deleteById(id);

        return new ResponseEntity<>("Agencia excluida com sucesso",HttpStatus.CREATED);

    }

}
