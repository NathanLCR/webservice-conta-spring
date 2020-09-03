package com.bank.bank.agenciaBancarias.entities;

import lombok.*;

import javax.persistence.*;

@Entity @NoArgsConstructor @Data
public class AgenciaBancaria {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50)
    private String nomeAgencia;

    public AgenciaBancaria (String nomeAgencia){
        this.nomeAgencia = nomeAgencia;
    }
}
