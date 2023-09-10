package com.paulocavalcante.unichristusteste.response;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.User;
import com.paulocavalcante.unichristusteste.entity.Veiculo;
import com.paulocavalcante.unichristusteste.enums.Turno;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransladoResponse {

    private  Long id;

    @NotNull
    private LocalDate dataDesejada;

    @NotNull
    private Turno turno;

    @NotNull
    private User user;

    @NotNull
    private Veiculo veiculo;

    @NotNull
    private Destino destino;
}
