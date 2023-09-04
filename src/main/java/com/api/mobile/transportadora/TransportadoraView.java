package com.api.mobile.transportadora;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="TransportadoraView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransportadoraView {
    @Id

    private Long codigo;
    private String razao;
    private String nomefantasia;
    private String nomefantasiacidadeuf;
    private String cidade;
    private String estado;
    private String telefone;
    private String cnpj;
    private String inscest;
    private String email;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String pais;
    private String observacoes;

}
