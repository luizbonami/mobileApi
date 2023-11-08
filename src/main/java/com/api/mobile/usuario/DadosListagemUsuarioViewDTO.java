package com.api.mobile.usuario;


public record DadosListagemUsuarioViewDTO(Long codigo, String nome, String codigoRepresentante, String senha ) {

    public DadosListagemUsuarioViewDTO(UsuarioView usuarioView){
        this(usuarioView.getCodigo(),
                usuarioView.getNome(),
                usuarioView.getCodigoRepresentante(),
                usuarioView.getSenha());
    }
}
