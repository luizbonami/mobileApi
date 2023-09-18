package com.api.mobile.itensmovimentacoes;


import com.api.mobile.movimentacoes.Movimentacoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Table(name="ITENSMOVIMENTACOES")
@Entity(name="ITENSMOVIMENTACOES")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Itensmovimentacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="CODMOV")
    private Movimentacoes movimentacoes;

    private Long codcoligada;
    private Long codfilial;
    private Long codigoFilialOrigem;
    private Long codigoFilialDestino;
    private Long codlocalestoque;
    private Long codlocaldestino;
    private Long codigoUnidade;
    private Long codproduto;
    private  String idproduto;
    private  String identificadorProduto;
    private  String descproduto;
    private  Float quantidade;
    private  Float valorunitario;
    private  Float valorunitarioCalculado;
    private  Float valorunitarioLiquido;
    private  Float valorunitarioOriginal;
    private  Float valortotal;
    private  Float valortotalLiquido;


    public Itensmovimentacoes(DadosCadastroItens dados){
        this.codcoligada = 1L;
        this.codfilial = 1L;
        this.codlocalestoque =dados.codigoLocalEstoque();
        this.codigoUnidade = dados.codigoUnidade();
        this.codproduto = dados.codigoProduto();
        this.idproduto = dados.idprd();
        this.identificadorProduto = dados.codigoSimilar();
        this.descproduto = dados.descricaoProduto();
        this.quantidade = dados.quantidade();
        this.valorunitario = dados.valorUnitario();
        this.valorunitarioCalculado = dados.valorUnitario();
        this.valorunitarioLiquido = dados.valorUnitario();
        this.valorunitarioOriginal = dados.valorUnitario();
        this.valortotal = dados.valorTotal();
        this.valortotalLiquido = dados.valorTotal();
    }
    public Long getCodmov() {
        if (this.movimentacoes != null) {
            return this.movimentacoes.getCodigo();
        }
        return null;
    }

}
