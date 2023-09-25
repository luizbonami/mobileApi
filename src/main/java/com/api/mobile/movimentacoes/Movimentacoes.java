package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.DadosCadastroItens;
import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;





@Entity(name="MOVIMENTACOES")
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
    private Long codusuario;
    private Long codigoUsuario;
    private Long codfuncionario1;
    private Long codigoTipomovimento;
    private Long codserie;
    private Long codlocalorigem;
    private Long codlocaldestino;
    private Long codfilialorigem;
    private Long codfilialdestino;
    private Long indicaPresencaTipoVenda;
    private Long codcentrocusto;
    private Long codigoEventofinanceiro;
    private  String idmov;
    private  String codtipomov;
    private Long codcliforn;
    private Long codrepresentante;
    private Long codcondicoespagamento;
    @Transient
    private String desccondpagamento;

    private Long codigoTipopagamento;
    private Long codtransportadora;
    private LocalDate dataemissao;
    private LocalDate dataentrega;
    private LocalDate dataentrada;
    private LocalDateTime datageracao;
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
        this.codusuario = dados.codigoUsuario();
        this.codigoUsuario = dados.codigoUsuario();
        this.codfuncionario1 = dados.codigoUsuario();
        this.codigoTipomovimento = dados.codigoTipoMovimento();
        this.codserie = dados.codigoSerie();
        this.codlocalorigem = dados.codlocalorigem();
        this.codlocaldestino = dados.codlocaldestino();
        this.codfilialorigem = dados.codfilialorigem();
        this.codfilialdestino = dados.codfilialdestino();
        this.idmov = dados.idmov();
        this.codtipomov = dados.codigoTipoMov();
        this.codcliforn = dados.codigoClienteFornecedor();
        this.codrepresentante = dados.codigoRepresentante();
        this.codcondicoespagamento = dados.codigoCodicaoPagamento();
        this.codigoTipopagamento = dados.codigoTipoPagamento();
        this.dataemissao = dados.dataEmissao();
        this.dataentrega = dados.dataEntrega();
        this.dataentrada = dados.dataentrada();
        this.datageracao = dados.datageracao();
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

    public void atualizarDadosMovimento(DadosAtualizacaoMovimentacoes dados) {
        if (dados.dataEntrega() != null){
            this.dataentrega = dados.dataEntrega();
        }
        if (dados.observacaoFiscal() != null){
            this.observacoes = dados.observacaoFiscal();
        }
        if (dados.observacaoMovimento() != null){
            this.observacoesMovimento = dados.observacaoMovimento();
        }
        if (dados.valorTotalItens() != null){
            this.valortotal = dados.valorTotalItens();
        }
        if (dados.valorTotalPedido() != null){
            this.valorliquido = dados.valorTotalPedido();
        }
    }
}
