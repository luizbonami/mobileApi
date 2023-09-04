package com.api.mobile.tributacao;

public record DadosListagemTributacaoViewDTO(Long codigo,
                                             Long codigoGrupoTributacao,
                                             Long codigoClassificacaoFiscal,
                                             String UF,
                                             Float percentualReducaoBaseIcms,
                                             Float ReducaoIcmsValor,
                                             Float aliquotaIcms,
                                             Float MVA,
                                             Float aliquotaIcmsST,
                                             Float reducaoIcmsST,
                                             Float aliquotaIPI) {
    public DadosListagemTributacaoViewDTO(TributacaoView tributacaoView){
        this(tributacaoView.getCodigo(),
              tributacaoView.getCodigogrupotributacao(),
                tributacaoView.getCodigoclassificacaofiscal(),
                tributacaoView.getUF(),
                tributacaoView.getPercentualreducaobaseicms(),
                tributacaoView.getReducaoicmsvalor(),
                tributacaoView.getAliquotaicms(),
                tributacaoView.getMVA(),
                tributacaoView.getAliquotaicmsst(),
                tributacaoView.getReducaoicmsst(),
                tributacaoView.getAliquotaipi());

    }
}
