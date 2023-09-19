package com.api.mobile.historicoproduto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name="HistoricoProdutoView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigomovimentacao")
public class HistoricoProdutoView {
    @Id
    private Long codigomovimentacao;
    private Long codigocliente;
    private LocalDate dataemissao;
    private String numeronota;
    private Long codigoproduto;
    private  String idproduto;
    private String codigosimilar;
    private Float valorunitario;
    private Float valorunitariocomtributo;


}
