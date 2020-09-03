package com.bank.bank.contas.entities;

import com.bank.bank.agenciaBancarias.entities.AgenciaBancaria;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50)
    private String titular;

    @ManyToOne()
    @Column()
    private AgenciaBancaria agenciaBancaria;

    @Column()
    private float saldo;

    public Conta(String titular){
        this.titular = titular;

        this.saldo = 0;
    }


}
