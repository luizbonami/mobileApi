package com.api.mobile.cliente;

import com.api.mobile.contato.DadosCadastroContato;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DadosCadastroCliente(Long codigoFilial,
                                   @NotBlank  // BeanValidation  usado para validação  tem que usar o @Valid no controller
                                   String razao,
                                   String nomefantasia,
                                   String cnpj,
                                   String inscricaoEstadual,
                                   Long codigoAreaatuacao,
                                   String rua,
                                   String numero,
                                   String complemento,
                                   String bairro,
                                   String cidade,
                                   String estado,
                                   String cep,
                                   String fone,
                                   String email,
                                   String observacoes,

                                   List<DadosCadastroContato> contato

                                   ) {
}
