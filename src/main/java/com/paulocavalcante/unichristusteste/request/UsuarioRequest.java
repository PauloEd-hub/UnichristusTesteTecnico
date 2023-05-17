package com.paulocavalcante.unichristusteste.request;


import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequest {

    private String nome;

    private String login;

    private String senha;

    private TipoDeUsuario tipoDeUsuario;
}
