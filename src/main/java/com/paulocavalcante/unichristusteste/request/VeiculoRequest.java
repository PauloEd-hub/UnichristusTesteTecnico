package com.paulocavalcante.unichristusteste.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VeiculoRequest {

    private String descricao;

    private int ocupacaoMaxima;
}
