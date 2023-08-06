package com.api.mobile.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="ProdutoView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigoProduto")
public class ProdutoView {

    @Id
    private Long codigoproduto;
    private  String idprd;
    private  String codigosimilar;
    private  String descricaoproduto;
    private  String descricaotecnica;
    private  Long codigosubgrupo;
    private  String descsubgrupo;
    private  Long codigofamilia1;
    private  String descfamilia1;
    private  Long codigofamilia2;
    private  String descfamilia2;
    private  Long codigofamilia3;
    private  String descfamilia3;
    private  Long codigofamilia4;
    private  String descfamilia4;
    private  String descunidadefisica;
    private  String descunidadefaturamento;
    private  Float pesobruto;
    private  Float pesoliquido;
    private  Long codclassificacaofiscal;
    private  Float precovenda;
    private  Float saldo;
    private  String embalagem;
}
