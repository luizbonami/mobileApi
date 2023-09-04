package com.api.mobile.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "UsuarioView")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioView {
    @Id
    private Long codigo;
    private String nome;
    private String codigoRepresentante;
}
