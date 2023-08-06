package com.api.mobile.condicaopagamento;

public record DadosListagemCondicaoPagamentoDTO(Long codigoCondPagamento, String descCondpagamento) {

    public  DadosListagemCondicaoPagamentoDTO(CondicaoPagamentoView condicaoPagamentoView){
        this(condicaoPagamentoView.getCodigocondpagamento(),
             condicaoPagamentoView.getDesccondpagamento() );
    }
}
