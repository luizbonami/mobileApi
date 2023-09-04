package com.api.mobile.tributacao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name="TributacaoView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TributacaoView {
    @Id
    private Long codigo;
    private Long codigogrupotributacao;
    private Long codigoclassificacaofiscal;
    private String UF;
    private Float percentualreducaobaseicms;
    private Float reducaoicmsvalor;
    private Float aliquotaicms;
    private Float MVA;
    private Float aliquotaicmsst;
    private Float reducaoicmsst;
    private Float aliquotaipi;
}
