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
public class UsuarioResponse {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private TipoDeUsuario tipoDeUsuario;
}
