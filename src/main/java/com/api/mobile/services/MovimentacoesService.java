package com.api.mobile.services;

import com.api.mobile.itensmovimentacoes.DadosCadastroItens;
import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;
import com.api.mobile.itensmovimentacoes.ItensmovimentacoesRepository;
import com.api.mobile.movimentacoes.DadosCadastroMovimentacoes;
import com.api.mobile.movimentacoes.Movimentacoes;
import com.api.mobile.movimentacoes.MovimentacoesRepository;
import com.api.mobile.serie.Series;
import com.api.mobile.serie.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Service
public class MovimentacoesService {

    @Autowired
    MovimentacoesRepository movimentacoesRepository;

    @Autowired
    ItensmovimentacoesRepository itensmovimentacoesRepository;

    @Autowired
    SeriesRepository seriesRepository;
    @Transactional // coloquei, pois estou atualizando 2 entidades estava atualizando a Serie quando falhava ao criar o movimento
    public Movimentacoes criarMovimento(DadosCadastroMovimentacoes dadosCadastroMovimentacoes){
        Movimentacoes movimentacoes = new Movimentacoes();
        movimentacoes.setCodcoligada(dadosCadastroMovimentacoes.codigoColigada());
        movimentacoes.setCodfilial(dadosCadastroMovimentacoes.codigoFilial());
        movimentacoes.setCodusuario(dadosCadastroMovimentacoes.codigoUsuario());
        movimentacoes.setCodigoUsuario(dadosCadastroMovimentacoes.codigoUsuario());
        movimentacoes.setCodfuncionario1(dadosCadastroMovimentacoes.codigoUsuario());
        movimentacoes.setCodlocalorigem(1L);
        movimentacoes.setCodlocaldestino(1L);
        movimentacoes.setCodfilialorigem(dadosCadastroMovimentacoes.codigoFilial());
        movimentacoes.setCodfilialdestino(dadosCadastroMovimentacoes.codigoFilial());
        movimentacoes.setIdmov(RetornaIdmov(dadosCadastroMovimentacoes.codigoSerie()));
        movimentacoes.setCodigoTipomovimento(dadosCadastroMovimentacoes.codigoTipoMovimento());
        movimentacoes.setCodserie(dadosCadastroMovimentacoes.codigoSerie());
        movimentacoes.setCodtipomov(dadosCadastroMovimentacoes.codigoTipoMov());
        movimentacoes.setCodcliforn(dadosCadastroMovimentacoes.codigoClienteFornecedor());
        movimentacoes.setCodrepresentante(dadosCadastroMovimentacoes.codigoRepresentante());
        movimentacoes.setCodcondicoespagamento(dadosCadastroMovimentacoes.codigoCodicaoPagamento());
        movimentacoes.setCodigoTipopagamento(dadosCadastroMovimentacoes.codigoTipoPagamento());
        movimentacoes.setCodtransportadora(dadosCadastroMovimentacoes.codigoTransportadora());
        movimentacoes.setIndicaPresencaTipoVenda(3L);
        movimentacoes.setCodcentrocusto(51L);
        movimentacoes.setCodigoEventofinanceiro(7L);
        movimentacoes.setDataemissao(dadosCadastroMovimentacoes.dataEmissao());
        movimentacoes.setDataentrega(dadosCadastroMovimentacoes.dataEntrega());
        movimentacoes.setDataentrada(dadosCadastroMovimentacoes.dataEmissao());
        movimentacoes.setDatageracao(LocalDateTime.now());
        movimentacoes.setValortotal(dadosCadastroMovimentacoes.valorTotalItens());
        movimentacoes.setValorliquido(dadosCadastroMovimentacoes.valorTotalPedido());
        movimentacoes.setNupedidoWmw(dadosCadastroMovimentacoes.numeroApi());
        movimentacoes.setObservacoes(dadosCadastroMovimentacoes.observacaoFiscal());
        movimentacoes.setObservacoesMovimento(dadosCadastroMovimentacoes.observacaoMovimento());
        movimentacoes.setStatus(dadosCadastroMovimentacoes.status());

        for (DadosCadastroItens itemDTO : dadosCadastroMovimentacoes.itens()) {
            Itensmovimentacoes item = new Itensmovimentacoes();
            item.setMovimentacoes(movimentacoes);
            item.setCodcoligada(itemDTO.codigoFilial()); //passando a filial para a coligada
            item.setCodfilial(itemDTO.codigoFilial());
            item.setCodigoFilialOrigem(itemDTO.codigoFilial());
            item.setCodigoFilialDestino(itemDTO.codigoFilial());
            item.setCodlocalestoque(itemDTO.codigoLocalEstoque());
            item.setCodlocaldestino(itemDTO.codigoLocalEstoque());
            item.setCodigoUnidade(itemDTO.codigoUnidade());
            item.setCodproduto(itemDTO.codigoProduto());
            item.setIdproduto(itemDTO.idprd());
            item.setIdentificadorProduto(itemDTO.codigoSimilar());
            item.setDescproduto(itemDTO.descricaoProduto());
            item.setQuantidade(itemDTO.quantidade());
            item.setValorunitario(itemDTO.valorUnitario());
            item.setValorunitarioCalculado(itemDTO.valorUnitario());
            item.setValorunitarioLiquido(itemDTO.valorUnitario());
            item.setValorunitarioOriginal(itemDTO.valorUnitario());
            item.setValortotal(itemDTO.valorTotal());
            item.setValortotalLiquido(itemDTO.valorTotal());

            movimentacoes.getItens().add(item);
        }
        return movimentacoesRepository.save(movimentacoes);
    }

    private String RetornaIdmov(Long codSerie) {
        Series serie = seriesRepository.findById(codSerie).orElse(null);
        String ultnumeroAtualizado = null;
        if (serie != null) {
            String ultnumero = serie.getUltnumero();
            try {
                int numericValue = Integer.parseInt(ultnumero);
                numericValue++;
                ultnumeroAtualizado = Integer.toString(numericValue);
                serie.setUltnumero(ultnumeroAtualizado);
                seriesRepository.save(serie);

            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter ultimo numero da serie");
            }
        }
        return ultnumeroAtualizado;
    }


}
