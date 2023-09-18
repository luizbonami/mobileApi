package com.api.mobile.itensmovimentacoes;

public record DadosListagemItens(
        Long codigo,
        Long codigoFilial,
        Long codigoLocalEstoque,
        Long codigoUnidade,
        Long codigoProduto,

        Long codMov,
        String idprd,
        String codigoSimilar,
        String descricaoProduto,
        Float quantidade,
        Float valorUnitario,
        Float valorTotal
) {

    public  DadosListagemItens(Itensmovimentacoes itensmovimentacoes){
        this(itensmovimentacoes.getCodigo(),
                itensmovimentacoes.getCodfilial(),
                itensmovimentacoes.getCodlocalestoque(),
                itensmovimentacoes.getCodigoUnidade(),
                itensmovimentacoes.getCodproduto(),
                itensmovimentacoes.getCodmov(),
                itensmovimentacoes.getIdproduto(),
                itensmovimentacoes.getIdentificadorProduto(),
                itensmovimentacoes.getDescproduto(),
                itensmovimentacoes.getQuantidade(),
                itensmovimentacoes.getValorunitario(),
                itensmovimentacoes.getValortotal()
        );
    }

}
