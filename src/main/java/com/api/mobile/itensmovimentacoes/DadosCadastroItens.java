package com.api.mobile.itensmovimentacoes;

import lombok.Getter;


public record DadosCadastroItens(
    Long codigoLocalEstoque,
    Long codigoUnidade,
    Long codigoProduto,
    String idprd,
    String codigoSimilar,
    String descricaoProduto,
    Float quantidade,
    Float valorUnitario,
    Float valorTotal){


}
