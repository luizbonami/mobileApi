package com.api.mobile.historicoproduto;

import java.time.LocalDate;

public record DadosListagemHistorioProdutoView(Long codigoMovimentacao,
                                               Long codigoCliente,
                                               LocalDate dataEmissao,
                                               String numeroNota,
                                               Long codigoProduto,
                                               String idProduto,
                                               String codigoSimilar,
                                               Float valorUnitario,
                                               Float valorUnitarioComTributo ) {
    public DadosListagemHistorioProdutoView(HistoricoProdutoView historicoProdutoView){
        this(historicoProdutoView.getCodigomovimentacao(),
                historicoProdutoView.getCodigocliente(),
                historicoProdutoView.getDataemissao(),
                historicoProdutoView.getNumeronota(),
                historicoProdutoView.getCodigoproduto(),
                historicoProdutoView.getIdproduto(),
                historicoProdutoView.getCodigosimilar(),
                historicoProdutoView.getValorunitario(),
                historicoProdutoView.getValorunitariocomtributo());
    }
}
