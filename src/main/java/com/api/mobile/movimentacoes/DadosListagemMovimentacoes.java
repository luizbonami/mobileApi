package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.DadosListagemItens;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemMovimentacoes(
        Long codigo,
        Long codigoFilial,
        Long codigoColigada,
        Long codigoUsuario,
        Long codigoVendedor,

        String descVendedor,
        Long codigoTipoMovimento,
        Long codigoSerie,
        String codigoTipoMov,
        Long codigoClienteFornecedor,
        String nomeCliente,
        Long codigoRepresentante,
        Long codigoCodicaoPagamento,
        String descCondpagamento,
        Long codigoTipoPagamento,
        String descricaoTipoPagamento,
        Long codigoTransportadora,
        String descTransportadora,
        String idmov,
        LocalDate dataEmissao,
        LocalDate dataEntrega,
        LocalDate dataEntradaSaida,
        Float valorTotalItens,
        Float valorTotalPedido,
        String numeroApi,
        String observacaoFiscal,
        String observacaoMovimento,
        Long status,
        Long totalDeprodutos,
        Long codigoGrupoTributacao,
        Float descontoPadrao,
        String estado,
        List<DadosListagemItens> itens


) {
    public  DadosListagemMovimentacoes(MovimentacoesView movimentacoes){
        this(movimentacoes.getCodigo(),
                movimentacoes.getCodfilial(),
                movimentacoes.getCodcoligada(),
                movimentacoes.getCodusuario(),
                movimentacoes.getCodfuncionario1(),
                movimentacoes.getNomefuncionario1(),
                movimentacoes.getCodigoTipomovimento(),
                movimentacoes.getCodserie(),
                movimentacoes.getCodtipomov(),
                movimentacoes.getCodcliforn(),
                movimentacoes.getNomecliente(),
                movimentacoes.getCodrepresentante(),
                movimentacoes.getCodcondicoespagamento(),
                movimentacoes.getDesccondpagamento(),
                movimentacoes.getCodigoTipopagamento(),
                movimentacoes.getDescricaotipopagamento(),
                movimentacoes.getCodtransportadora(),
                movimentacoes.getDesctransportadora(),
                movimentacoes.getIdmov(),
                movimentacoes.getDataemissao(),
                movimentacoes.getDataentrega(),
                movimentacoes.getDataentrada(),
                movimentacoes.getValortotal(),
                movimentacoes.getValorliquido(),
                movimentacoes.getNupedidoWmw(),
                movimentacoes.getObservacoes(),
                movimentacoes.getObservacoesMovimento(),
                movimentacoes.getStatus(),
                movimentacoes.getTotaldeprodutos(),
                movimentacoes.getCodigogrupotributacao(),
                movimentacoes.getDescontopadrao(),
                movimentacoes.getEstado(),
                movimentacoes.getItens().stream().map(DadosListagemItens::new).toList());
    }



}

