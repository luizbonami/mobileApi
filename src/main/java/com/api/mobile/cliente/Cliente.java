package com.api.mobile.cliente;

import com.api.mobile.contato.Contato;
import com.api.mobile.contato.DadosCadastroContato;
import com.api.mobile.itensmovimentacoes.DadosCadastroItens;
import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name="CLIFORN")
@Entity(name="CLIFORN")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codigoFilial;
    private String razao;
    private String nomefantasia;
    private String tipo;
    private String pesfisoujur;
    private String cnpj;
    private String inscest;
    private Long codigoAreaatuacao;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private Long codigoPais;
    private Long codigoMunicipios;
    private String cep;
    private String fone;
    private String email;
    private String ativo;
    private LocalDate dataCadastro;
    private String observacoes;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contato = new ArrayList<>();


}
