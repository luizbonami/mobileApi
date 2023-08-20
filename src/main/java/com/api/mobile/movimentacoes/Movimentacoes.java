package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.DadosCadastroItens;
import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name="MOVIMENTACOES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Movimentacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codcoligada;
    private Long codfilial;
    private Long codigoTipomovimento;
    private  String codtipomov;
    private Long codcliforn;
    private Long codrepresentante;
    private Long codcondicoespagamento;
    private Long codigoTipopagamento;
    private Date dataemissao;
    private Date dataentrega;
    private Float valortotal;
    private Float valorliquido;
    private String nupedidoWmw;
    private String observacoes;
    private String observacoesMovimento;
    private Long status;

   // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "movimentacoes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itensmovimentacoes> itens = new ArrayList<>();


    public Movimentacoes(DadosCadastroMovimentacoes dados){
        this.codcoligada = dados.codigoColigada();
        this.codfilial = dados.codigoFilial();
        this.codigoTipomovimento = dados.codigoTipoMovimento();
        this.codtipomov = dados.codigoTipoMov();
        this.codcliforn = dados.codigoClienteFornecedor();
        this.codrepresentante = dados.codigoRepresentante();
        this.codcondicoespagamento = dados.codigoCodicaoPagamento();
        this.codigoTipopagamento = dados.codigoTipoPagamento();
        this.dataemissao = dados.dataEmissao();
        this.dataentrega = dados.dataEntrega();
        this.valortotal = dados.valorTotalItens();
        this.valorliquido = dados.valorTotalPedido();
        this.nupedidoWmw = dados.numeroApi();
        this.observacoes = dados.observacaoFiscal();
        this.observacoesMovimento = dados.observacaoMovimento();
        this.status =  dados.status();

        for (DadosCadastroItens itemDTO : dados.itens()) {
            Itensmovimentacoes item = new Itensmovimentacoes();

            item.setCodcoligada(1L);
            item.setCodfilial(1L);
            item.setCodlocalestoque(itemDTO.codigoLocalEstoque());
            item.setCodigoUnidade(itemDTO.codigoUnidade());
            item.setCodproduto(itemDTO.codigoProduto());
            item.setIdproduto(itemDTO.idprd());
            item.setIdentificadorProduto(itemDTO.codigoSimilar());
            item.setDescproduto(itemDTO.descricaoProduto());
            item.setQuantidade(itemDTO.quantidade());
            item.setValorunitario(itemDTO.valorUnitario());
            item.setValortotal(itemDTO.valorTotal());
            this.itens.add(item);
        }


    }

}
