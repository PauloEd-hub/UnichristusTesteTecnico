package com.paulocavalcante.unichristusteste.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Translado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate dataDesejada;

    @Column
    private char turno;

    @Column
    private List<Destinos> destinos;

    @Column
    private List<Veiculo> veiculos;
}
