package com.paulocavalcante.unichristusteste.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinoResponse {

    private Long id;

    private String nome;

    private String sigla;
}
