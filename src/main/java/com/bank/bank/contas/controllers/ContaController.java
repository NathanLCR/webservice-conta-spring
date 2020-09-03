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

    @GetMapping("")
    public Iterable<Conta> getAll(){

        return contaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id){

        Optional<Conta> conta = contaRepository.findById(id);


        if (conta.isEmpty()){
            return new ResponseEntity<>("Conta não encontrada",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(conta,HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Conta conta){

        if (conta.getTitular() == null){
            return new ResponseEntity<>("Dados invalidos",HttpStatus.BAD_REQUEST);
        }

        contaRepository.save(conta);

        return new ResponseEntity<>("Conta criada com sucesso",HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity update(@RequestBody Conta newConta,@PathVariable int id){
//
//        if (contaRepository.existsById(id))
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @DeleteMapping("${id}")
    public ResponseEntity delete(@PathVariable int id){

        contaRepository.deleteById(id);

        if (!contaRepository.existsById(id)){
            return new ResponseEntity<>("Conta inexistente",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Conta deletada com sucesso",HttpStatus.OK);

    }

}
