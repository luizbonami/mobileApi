package com.api.mobile.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.NoArgsConstructor;


@Entity(name="ClienteDadosFinanceiros")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigocliente")
public class ClienteDadosFinanceiros {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigocliente;
    private Long codigorepresentante;
    private Float valormaiorfatura;
    private Float valormediocompra;
    private Float valorsaldocliente;
    private Long qtmediadiasatraso;
    private Float valortotalvenda;
    private Long quantidadetotalvenda;

}
