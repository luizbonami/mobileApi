package com.api.mobile.representante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="REPRESENTANTES")
@Entity(name="REPRESENTANTES")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Representante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private  String nome;
    private String nomefantasia;
    private String cnpj;
    private String email;
    private String contato;

    @Embedded
    private Endereco endereco;


    public Representante(DadosCadastroRepresentante dados) {
        this.nome = dados.nome();
        this.nomefantasia = dados.nomefantasia();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
        this.contato = dados.contato();
        this.endereco = new Endereco(dados.endereco());
    }
}
