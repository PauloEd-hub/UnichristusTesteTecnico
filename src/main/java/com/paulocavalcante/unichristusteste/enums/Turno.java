package com.paulocavalcante.unichristusteste.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Turno {
    MANHA("manha"),
    TARDE("tarde"),
    NOITE("noite");

    private String turno;
}
