package com.api.mobile.representante;

import java.awt.*;

public record DadosDoEndereco(
        String rua,
        String numero,
        String bairro,
        String complemento,
        String cep,
        String pais

        ) {
}
