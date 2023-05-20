package com.paulocavalcante.unichristusteste.request;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class TransladoRequest {

    @NotBlank(message = "Informe a data desejada")
    private LocalDate dataDesejada;

    @NotBlank(message = "Informe o turno")
    private char turno;

//    private Usuario usuario;

    @NotBlank(message = "Informe o veículo")
    private Veiculo veiculo;

    @NotBlank(message = "Informe o destino")
    private Destino destino;
}
