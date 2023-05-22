package com.paulocavalcante.unichristusteste.request;

import com.paulocavalcante.unichristusteste.enums.Turno;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TransladoRequestSimplificado {

    @NotNull
    private LocalDate dataDesejada;

    @NotNull
    private Turno turno;

    @NotNull
    private Long id_usuario;

    @NotNull
    private Long id_veiculo;

    @NotNull
    private Long id_destino;


}
