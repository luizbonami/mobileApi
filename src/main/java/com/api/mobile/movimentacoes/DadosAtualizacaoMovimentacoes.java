package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.DadosAtualizacaoItens;

import java.time.LocalDate;
import java.util.List;

public record DadosAtualizacaoMovimentacoes(Long codigo,
                                           LocalDate dataEntrega,
                                            Float valorTotalItens,
                                            Float valorTotalPedido,
                                            String observacaoFiscal,
                                            String observacaoMovimento,

                                            List<DadosAtualizacaoItens> itens) {
}
