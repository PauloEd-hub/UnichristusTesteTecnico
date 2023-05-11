package com.paulocavalcante.unichristusteste.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioAlunoRequest {

    private String nome;

    private String login;

    private String senha;
}
