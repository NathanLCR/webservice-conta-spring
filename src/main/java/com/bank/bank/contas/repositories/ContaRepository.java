package com.bank.bank.contas.repositories;

import com.bank.bank.contas.entities.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta,Integer>{
}
