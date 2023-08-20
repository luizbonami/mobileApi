package com.api.mobile.services;

import com.api.mobile.itensmovimentacoes.DadosCadastroItens;
import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;
import com.api.mobile.itensmovimentacoes.ItensmovimentacoesRepository;
import com.api.mobile.movimentacoes.DadosCadastroMovimentacoes;
import com.api.mobile.movimentacoes.Movimentacoes;
import com.api.mobile.movimentacoes.MovimentacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovimentacoesService {

    @Autowired
    MovimentacoesRepository movimentacoesRepository;

    @Autowired
    ItensmovimentacoesRepository itensmovimentacoesRepository;

    public Movimentacoes criarMovimento(DadosCadastroMovimentacoes dadosCadastroMovimentacoes){
        Movimentacoes movimentacoes = new Movimentacoes();
        movimentacoes.setCodcoligada(dadosCadastroMovimentacoes.codigoColigada());
        movimentacoes.setCodfilial(dadosCadastroMovimentacoes.codigoFilial());
        movimentacoes.setCodigoTipomovimento(dadosCadastroMovimentacoes.codigoTipoMovimento());
        movimentacoes.setCodtipomov(dadosCadastroMovimentacoes.codigoTipoMov());
        movimentacoes.setCodcliforn(dadosCadastroMovimentacoes.codigoClienteFornecedor());
        movimentacoes.setCodrepresentante(dadosCadastroMovimentacoes.codigoRepresentante());
        movimentacoes.setCodcondicoespagamento(dadosCadastroMovimentacoes.codigoCodicaoPagamento());
        movimentacoes.setCodigoTipopagamento(dadosCadastroMovimentacoes.codigoTipoPagamento());
        movimentacoes.setDataemissao(dadosCadastroMovimentacoes.dataEmissao());
        movimentacoes.setDataentrega(dadosCadastroMovimentacoes.dataEntrega());
        movimentacoes.setValortotal(dadosCadastroMovimentacoes.valorTotalItens());
        movimentacoes.setValorliquido(dadosCadastroMovimentacoes.valorTotalPedido());
        movimentacoes.setNupedidoWmw(dadosCadastroMovimentacoes.numeroApi());
        movimentacoes.setObservacoes(dadosCadastroMovimentacoes.observacaoFiscal());
        movimentacoes.setObservacoesMovimento(dadosCadastroMovimentacoes.observacaoMovimento());
        movimentacoes.setStatus(dadosCadastroMovimentacoes.status());

        for (DadosCadastroItens itemDTO : dadosCadastroMovimentacoes.itens()) {
            Itensmovimentacoes item = new Itensmovimentacoes();
            item.setMovimentacoes(movimentacoes);
            item.setCodcoligada(1L);
            item.setCodfilial(1L);
            item.setCodlocalestoque(itemDTO.codigoLocalEstoque());
            item.setCodigoUnidade(itemDTO.codigoUnidade());
            item.setCodproduto(itemDTO.codigoProduto());
            item.setIdproduto(itemDTO.idprd());
            item.setIdentificadorProduto(itemDTO.codigoSimilar());
            item.setDescproduto(itemDTO.descricaoProduto());
            item.setQuantidade(itemDTO.quantidade());
            item.setValorunitario(itemDTO.valorUnitario());
            item.setValortotal(itemDTO.valorTotal());

            movimentacoes.getItens().add(item);
        }
        return movimentacoesRepository.save(movimentacoes);
    }





}
