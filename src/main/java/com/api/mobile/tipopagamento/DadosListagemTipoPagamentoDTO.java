package com.api.mobile.tipopagamento;

public record DadosListagemTipoPagamentoDTO( Long codigoTipoPagamento,
         String descricaoTipoPagamento,
         String tipoCheque,
         String tipoBoleto) {

    public DadosListagemTipoPagamentoDTO(TipoPagamentoView tipoPagamentoView){
        this(tipoPagamentoView.getCodigotipopagamento(),
                tipoPagamentoView.getDescricaotipopagamento(),
                tipoPagamentoView.getTipocheque(),
                tipoPagamentoView.getTipoboleto());
    }
}
