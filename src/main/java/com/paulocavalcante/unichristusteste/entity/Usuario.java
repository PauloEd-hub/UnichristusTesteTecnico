package com.paulocavalcante.unichristusteste.entity;


import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import jakarta.persistence.*;
import lombok.*;

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

    @Column
    private String nome;

    @Column
    private String login;
    @Column
    private String senha;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario;

}
