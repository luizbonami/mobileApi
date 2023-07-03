package com.api.mobile.representante;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String pais;

    public Endereco(DadosDoEndereco endereco) {
        this.rua = endereco.rua();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.complemento = endereco.complemento();
        this.cep = endereco.cep();
        this.pais = endereco.pais();
    }
}
