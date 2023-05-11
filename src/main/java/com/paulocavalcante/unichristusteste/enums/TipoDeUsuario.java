package com.paulocavalcante.unichristusteste.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoDeUsuario {
    ADMINISTRACAO("administracao"),
    ALUNO("aluno");

    private String tipoDeUsario;
}
