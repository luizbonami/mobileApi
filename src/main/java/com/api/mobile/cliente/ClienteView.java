package com.api.mobile.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.NoArgsConstructor;


@Entity(name="ClienteView")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class ClienteView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codigoRepresentante;
    private String razao;
    private String nomefantasia;
    private String cidade;
    private String estado;
    private String telefone;
    private String cnpj;
    private String inscest;
    private String contato;
    private String email;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String pais;
    private String observacoes;

}
