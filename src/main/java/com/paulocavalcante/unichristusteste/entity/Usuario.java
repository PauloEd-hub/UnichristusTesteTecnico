package com.paulocavalcante.unichristusteste.entity;


import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String login;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Translado> translados;

}
