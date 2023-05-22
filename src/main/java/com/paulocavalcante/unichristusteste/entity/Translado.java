package com.paulocavalcante.unichristusteste.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.paulocavalcante.unichristusteste.enums.Turno;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDate dataDesejada;

    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonManagedReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @JsonManagedReference
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    @JsonManagedReference
    private Destino destino;

}
