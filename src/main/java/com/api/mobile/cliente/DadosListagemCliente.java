package com.api.mobile.cliente;

public record DadosListagemCliente(Long codigo
        ,Long codigoRepresentante
        ,String razao
        ,String nomeFantasia
        ,String cidade
        ,String estado
        ,String telefone
        ,String cnpj
        ,String inscest
        ,String contato
        ,String email
        ,String endereco
        ,String numero
        ,String bairro
        ,String cep
        ,String pais
        ,String observacoes
        ,Float valorLimiteCredito
        ,String statusClienteAtivo
        ,Float valorDescPadraoCF
        ,Long codigoContatoPrincipal
        ,String nomeContatoPrincipal
        ,String dataUltimoPedido
        ,Long codigoGrupoTributacao) {

    public DadosListagemCliente(ClienteView clienteView){
        this(clienteView.getCodigo(),
                clienteView.getCodigoRepresentante(),
                clienteView.getRazao(),
                clienteView.getNomefantasia(),
                clienteView.getCidade(),
                clienteView.getEstado(),
                clienteView.getTelefone(),
                clienteView.getCnpj(),
                clienteView.getInscest(),
                clienteView.getContato(),
                clienteView.getEmail(),
                clienteView.getEndereco(),
                clienteView.getNumero(),
                clienteView.getBairro(),
                clienteView.getCep(),
                clienteView.getPais(),
                clienteView.getObservacoes(),
                clienteView.getValorlimitecredito(),
                clienteView.getStatusclienteativo(),
                clienteView.getValordescpadraocf(),
                clienteView.getCodigocontatoprincipal(),
                clienteView.getNomecontatoprincipal(),
                clienteView.getDataultimopedido(),
                clienteView.getCodigogrupotributacao()
        );

    }

}
