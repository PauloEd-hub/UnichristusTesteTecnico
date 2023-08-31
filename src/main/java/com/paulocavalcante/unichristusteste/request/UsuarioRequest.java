package com.paulocavalcante.unichristusteste.request;

import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UsuarioRequest {

    @NotBlank(message = "Informe o nome")
    @NonNull
    private String nome;

    @NotBlank(message = "Informe o login válido")
    @NotNull
    private String email;

    @NotBlank(message = "Informe a senha")
    @Size(min = 8, max = 15)
    @NotNull
    private String senha;

    @NotNull
    private List<TipoDeUsuario> tipoDeUsuario;
}
