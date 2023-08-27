package com.api.mobile.representante;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="RepresentanteView")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class RepresentanteView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codigorepresentante;
    private String nome;
    private String nomefantasia;
    private String email;
    private String fone;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String senha;
    private String totalcliente;
}
