package com.bank.bank.contas.entities;

import com.bank.bank.agenciaBancarias.entities.AgenciaBancaria;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titular;

    @ManyToOne()
    private AgenciaBancaria agenciaBancaria;

    private float saldo;

    public Conta(String titular){
        this.titular = titular;

        this.saldo = 0;
    }


}
