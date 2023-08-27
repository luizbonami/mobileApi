package com.api.mobile.representante;

public record DadosListatemRepresentanteViewDTO(Long codigo, Long codigoRepresentante, String nome, String nomefantasia, String email, String fone,  String logradouro, String complemento, String bairro, String cep, String cidade, String estado, String pais,String senha, String totalCliente) {

    public  DadosListatemRepresentanteViewDTO(RepresentanteView representanteView ){
        this(representanteView.getCodigo(),
                representanteView.getCodigorepresentante(),
                representanteView.getNome(),
                representanteView.getNomefantasia(),
                representanteView.getEmail(),
                representanteView.getFone(),
                representanteView.getLogradouro(),
                representanteView.getComplemento(),
                representanteView.getBairro(),
                representanteView.getCep(),
                representanteView.getCidade(),
                representanteView.getEstado(),
                representanteView.getPais(),
                representanteView.getSenha(),
                representanteView.getTotalcliente());

    }
}
