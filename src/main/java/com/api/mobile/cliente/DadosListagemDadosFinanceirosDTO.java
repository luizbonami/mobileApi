package com.api.mobile.cliente;

public record DadosListagemDadosFinanceirosDTO( Long codigocliente
                          ,Long codigoRepresentante
                          ,Float valorMaiorFatura
                          ,Float valorMedioCompra
                          ,Float valorSaldoCliente
                          ,Long qtMediaDiasAtraso
                          ,Float valorTotalVenda
                          ,Long quantidadeTotalVenda) {

    public DadosListagemDadosFinanceirosDTO(ClienteDadosFinanceiros clienteDadosFinanceiros){
        this(   clienteDadosFinanceiros.getCodigocliente(),
                clienteDadosFinanceiros.getCodigorepresentante(),
                clienteDadosFinanceiros.getValormaiorfatura(),
                clienteDadosFinanceiros.getValormediocompra(),
                clienteDadosFinanceiros.getValorsaldocliente(),
                clienteDadosFinanceiros.getQtmediadiasatraso(),
                clienteDadosFinanceiros.getValortotalvenda(),
                clienteDadosFinanceiros.getQuantidadetotalvenda()
        );

    }
}
