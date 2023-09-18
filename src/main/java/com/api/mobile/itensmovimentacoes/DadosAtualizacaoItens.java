package com.api.mobile.itensmovimentacoes;

public record DadosAtualizacaoItens(
        Long codigo,
        Long codmov,
        Float quantidade,
        Float valorUnitario,
        Float valorTotal,
        Float valorTotalItemTributo) {
}
