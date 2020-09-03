package com.bank.bank.agenciaBancarias.entities;

import lombok.*;

import javax.persistence.*;

@Entity @NoArgsConstructor @Getter @Setter
public class AgenciaBancaria {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nomeAgencia;
}
