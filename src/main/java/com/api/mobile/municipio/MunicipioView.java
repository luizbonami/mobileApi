package com.api.mobile.municipio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="MunicipioView")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioView {
    @Id
    private Long codigo;
    private String nome;
    private String uf;

}
