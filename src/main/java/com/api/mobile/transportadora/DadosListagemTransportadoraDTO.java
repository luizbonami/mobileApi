package com.api.mobile.transportadora;

public record DadosListagemTransportadoraDTO( Long codigo,
                                              String razao,
                                              String nomeFantasia,
                                              String nomeFantasiaCidadeUF,
                                              String cidade,
                                              String estado,
                                              String telefone,
                                              String cnpj,
                                              String inscest,
                                              String email,
                                              String endereco,
                                              String numero,
                                              String bairro,
                                              String cep,
                                              String pais,
                                              String observacoes
                                              ) {
    public DadosListagemTransportadoraDTO(TransportadoraView transportadoraView){
        this(transportadoraView.getCodigo(),
                transportadoraView.getRazao(),
                transportadoraView.getNomefantasia(),
                transportadoraView.getNomefantasiacidadeuf(),
                transportadoraView.getCidade(),
                transportadoraView.getEstado(),
                transportadoraView.getTelefone(),
                transportadoraView.getCnpj(),
                transportadoraView.getInscest(),
                transportadoraView.getEmail(),
                transportadoraView.getEndereco(),
                transportadoraView.getNumero(),
                transportadoraView.getBairro(),
                transportadoraView.getCep(),
                transportadoraView.getPais(),
                transportadoraView.getObservacoes());
    }
}
