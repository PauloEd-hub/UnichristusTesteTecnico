package com.paulocavalcante.unichristusteste.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DestinoRequest {

    private String nome;

    private String sigla;
}
