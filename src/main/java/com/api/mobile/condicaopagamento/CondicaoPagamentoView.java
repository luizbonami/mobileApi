package com.api.mobile.condicaopagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="CondicaoPagamentoView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CondicaoPagamentoView {
    @Id
    private Long codigocondpagamento;
    private String desccondpagamento;
}
