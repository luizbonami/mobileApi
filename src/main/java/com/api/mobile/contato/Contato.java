package com.api.mobile.contato;

import com.api.mobile.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name="CONTATOSCFO")
@Table(name="CONTATOSCFO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codcliforn")
    private Cliente cliente;

    private String nomecontato;
    private String cargocontato;
    private LocalDate dataaniversariocontato;
    private String faxcontato;
    private LocalDate dataLivre1;
    private String  emailcontato;

}
