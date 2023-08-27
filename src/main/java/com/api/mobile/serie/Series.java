package com.api.mobile.serie;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="SERIESMOV")
@Table(name="SERIESMOV")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codcoligada;
    private Long codfilial;

    private String ultnumero;

}
