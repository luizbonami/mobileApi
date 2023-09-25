package com.api.mobile.movimentacoes;

import com.api.mobile.itensmovimentacoes.Itensmovimentacoes;
import com.api.mobile.itensmovimentacoes.ItensmovimentacoesView;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="MovimentacoesView")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class MovimentacoesView {
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
    private String nomecliente;
    private Long codrepresentante;
    private Long codcondicoespagamento;
    private String desccondpagamento;

    private Long codigoTipopagamento;
    private String descricaotipopagamento;
    private Long codtransportadora;
    private String desctransportadora;
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
    private  Long totaldeprodutos;


    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "movimentacoes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensmovimentacoesView> itens = new ArrayList<>();


}
