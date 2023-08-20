package com.api.mobile.movimentacoes;


import com.api.mobile.itensmovimentacoes.DadosCadastroItens;
import lombok.Getter;

import java.util.Date;
import java.util.List;


public record DadosCadastroMovimentacoes(
        Long codigoFilial,
        Long codigoColigada,
        Long codigoTipoMovimento,
        String codigoTipoMov,
        Long codigoClienteFornecedor,
        Long codigoRepresentante,
        Long codigoCodicaoPagamento,
        Long codigoTipoPagamento,
        Date dataEmissao,
        Date dataEntrega,
        Float valorTotalItens,
        Float valorTotalPedido,
        String numeroApi,
        String observacaoFiscal,
        String observacaoMovimento,
        Long status,

        List<DadosCadastroItens> itens

) {
}
