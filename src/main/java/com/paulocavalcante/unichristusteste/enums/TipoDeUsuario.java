package com.paulocavalcante.unichristusteste.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoDeUsuario {
    ADMINISTRACAO("0"),
    ALUNO("1");

    private String tipoDeUsario;
}
