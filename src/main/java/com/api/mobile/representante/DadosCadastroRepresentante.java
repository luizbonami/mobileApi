package com.api.mobile.representante;

public record DadosCadastroRepresentante(String nome,
                                         String nomefantasia,
                                         String cnpj,
                                         String cpf,
                                         String email,
                                         String contato,
                                         DadosDoEndereco endereco) {
}

