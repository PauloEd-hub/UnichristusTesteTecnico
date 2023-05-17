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
@Table(name = "translados")
public class Translado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate dataDesejada;

    @Column
    private char turno;


    @OneToMany
    private List<Destinos> destinos;


    private List<Veiculo> veiculos;
}
