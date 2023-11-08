package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.DadosCadastroItens;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record DadosAtualizacaoMovimentacoes(Long codigo,
                                            Long codigoFilial,
                                            Long codigoColigada,
                                            Long codigoUsuario,
                                            Long codigoTipoMovimento,
                                            Long codigoSerie,
                                            Long codlocalorigem,
                                            Long codlocaldestino,
                                            Long codfilialorigem,
                                            Long codfilialdestino,
                                            String idmov,
                                            String codigoTipoMov,
                                            Long codigoClienteFornecedor,
                                            Long codigoRepresentante,
                                            Long codigoCodicaoPagamento,
                                            Long codigoTipoPagamento,
                                            Long codigoTransportadora,
                                            LocalDate dataEmissao,
                                            LocalDate dataEntrega,
                                            LocalDate dataentrada,
                                            LocalDateTime datageracao,
                                            Float valorTotalItens,
                                            Float valorTotalPedido,
                                            String numeroApi,
                                            String observacaoFiscal,
                                            String observacaoMovimento,
                                            Long status,

                                            List<DadosCadastroItens> itens) {
}
