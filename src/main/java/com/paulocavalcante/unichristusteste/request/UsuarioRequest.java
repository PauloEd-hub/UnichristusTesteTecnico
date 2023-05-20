package com.paulocavalcante.unichristusteste.request;

import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequest {

    @NotBlank(message = "Informe o nome")
    private String nome;

    @NotBlank(message = "Informe o login válido")
    private String login;

    @NotBlank(message = "Informe a senha")
    @Size(min = 8, max = 15)
    private String senha;

    private TipoDeUsuario tipoDeUsuario;
}
