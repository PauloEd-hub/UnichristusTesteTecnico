package com.paulocavalcante.unichristusteste.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutheticationRequest {

    @NotBlank(message = "Informe o email")
    private String email;


    @NotBlank(message = "Informe a senha")
    private String passoword;

}
