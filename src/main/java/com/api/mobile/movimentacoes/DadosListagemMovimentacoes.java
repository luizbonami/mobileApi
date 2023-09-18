package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.DadosListagemItens;
import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemMovimentacoes(
        Long codigo,
        Long codigoFilial,
        Long codigoColigada,
        Long codigoUsuario,
        Long codigoTipoMovimento,
        Long codigoSerie,
        String codigoTipoMov,
        Long codigoClienteFornecedor,
        Long codigoRepresentante,
        Long codigoCodicaoPagamento,
        Long codigoTipoPagamento,
        Long codigoTransportadora,
        String idmov,
        LocalDate dataEmissao,
        LocalDate dataEntrega,
        Float valorTotalItens,
        Float valorTotalPedido,
        String numeroApi,
        String observacaoFiscal,
        String observacaoMovimento,
        Long status,

        List<DadosListagemItens> itens


) {
    public  DadosListagemMovimentacoes(Movimentacoes movimentacoes){
        this(movimentacoes.getCodigo(),
                movimentacoes.getCodfilial(),
                movimentacoes.getCodcoligada(),
                movimentacoes.getCodusuario(),
                movimentacoes.getCodigoTipomovimento(),
                movimentacoes.getCodserie(),
                movimentacoes.getCodtipomov(),
                movimentacoes.getCodcliforn(),
                movimentacoes.getCodrepresentante(),
                movimentacoes.getCodcondicoespagamento(),
                movimentacoes.getCodigoTipopagamento(),
                movimentacoes.getCodtransportadora(),
                movimentacoes.getIdmov(),
                movimentacoes.getDataemissao(),
                movimentacoes.getDataentrega(),
                movimentacoes.getValortotal(),
                movimentacoes.getValorliquido(),
                movimentacoes.getNupedidoWmw(),
                movimentacoes.getObservacoes(),
                movimentacoes.getObservacoesMovimento(),
                movimentacoes.getStatus(),
                movimentacoes.getItens().stream().map(DadosListagemItens::new).toList());
    }



}
