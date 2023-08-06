package com.api.mobile.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.NoArgsConstructor;

@Table(name="CLIFORN")
@Entity(name="CLIENTES")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private  String nomefantasia;
    private String razao;
    private String cnpj;
    private String cgccfo;
    private String email;
    private Integer codigo_areaatuacao;

}
