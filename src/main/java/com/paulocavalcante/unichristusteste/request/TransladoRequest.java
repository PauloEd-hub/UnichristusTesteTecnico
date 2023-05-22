package com.paulocavalcante.unichristusteste.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.entity.Veiculo;
import com.paulocavalcante.unichristusteste.enums.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
public class TransladoRequest {

    @NotBlank(message = "Informe o id")
    @NotNull
    private Long id;

    @NotBlank(message = "Informe a data desejada")
    @NotNull
    @JsonIgnore
    private LocalDate dataDesejada;

    @NotBlank(message = "Informe o turno")
    @NotNull
    private Turno turno;

//    private Usuario usuario;

    @NotBlank(message = "Informe o veículo")
    @NotNull
    private Veiculo veiculo;

    @NotBlank(message = "Informe o destino")
    @NotNull
    private Destino destino;
}
