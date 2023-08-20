package com.api.mobile.tipopagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="TipoPagamentoView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TipoPagamentoView {
    @Id
    private Long codigotipopagamento;
    private String descricaotipopagamento;
    private String tipocheque;
    private String tipoboleto;
}
