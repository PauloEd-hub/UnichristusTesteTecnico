package com.paulocavalcante.unichristusteste.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255)
    private String descricao;

    @Column
    private int ocupacaoMaxima;

    @JsonBackReference
    @OneToMany(mappedBy = "veiculo" )
    private List<Translado> translados;
}
