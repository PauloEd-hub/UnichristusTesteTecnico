package com.paulocavalcante.unichristusteste.response;

import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioAlunoResponse {

    private Long id;

    private String nome;

    private String login;

    private String senha;

    private TipoDeUsuario tipoDeUsuario = TipoDeUsuario.ALUNO;
}
