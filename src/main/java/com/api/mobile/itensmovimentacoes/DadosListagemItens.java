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
        Long quantidade,
        Float valorUnitario,
        Float valorTotal,
        Float valorUnitarioComTributo,
        Float valorTotalItemTributo,
        Float fiscalValorSt,
        Float fiscalValorIpi

) {

    public  DadosListagemItens(ItensmovimentacoesView itensmovimentacoes){
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
                itensmovimentacoes.getValortotal(),
                itensmovimentacoes.getValorunitariocomtributo(),
                itensmovimentacoes.getValortotalitemtributo(),
                itensmovimentacoes.getFiscalValorSt(),
                itensmovimentacoes.getFiscalValorIpi()
        );
    }

}
