package com.api.mobile.itensmovimentacoes;


import com.api.mobile.movimentacoes.MovimentacoesView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity(name="vApiItensmovimentacoes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class ItensmovimentacoesView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="CODMOV")
    private MovimentacoesView movimentacoes;

    private Long codfilial;
    private Long codlocalestoque;
    private Long codigoUnidade;
    private Long codproduto;
    private  String idproduto;
    private  String identificadorProduto;
    private  String descproduto;
    private  Long quantidade;
    private  Float valorunitario;
    private  Float valortotal;
    private Float valorunitariocomtributo;
    private  Float valortotalitemtributo;
    private Float fiscalValorSt;
    private Float fiscalValorIpi;



    public Long getCodmov() {
        if (this.movimentacoes != null) {
            return this.movimentacoes.getCodigo();
        }
        return null;
    }

}
