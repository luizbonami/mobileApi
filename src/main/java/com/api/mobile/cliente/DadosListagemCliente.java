package com.api.mobile.cliente;

public record DadosListagemCliente(Long codigo, Long codigoRepresentante, String razao, String nomefantasia,String cidade, String estado, String telefone, String cnpj, String inscest, String contato, String email, String endereco, String numero, String bairro, String cep, String pais, String observacoes) {

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
                clienteView.getObservacoes());

    }

}
