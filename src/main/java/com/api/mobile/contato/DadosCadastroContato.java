package com.api.mobile.contato;

import java.time.LocalDate;

public record DadosCadastroContato(
         String nomeContato,
         String cargoContato,
         LocalDate dataAniversarioContato,
         String whatsApp,
         String  emailContato

) {
}
