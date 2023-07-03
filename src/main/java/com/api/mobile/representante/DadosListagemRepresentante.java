package com.api.mobile.representante;

public record DadosListagemRepresentante(Long codigo, String nome, String nomefantasia ) {
    public  DadosListagemRepresentante(Representante representante){
        this(representante.getCodigo(), representante.getNome(), representante.getNomefantasia());
    }
}
