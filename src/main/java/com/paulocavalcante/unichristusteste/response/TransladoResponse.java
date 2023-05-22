package com.paulocavalcante.unichristusteste.response;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.entity.Veiculo;
import com.paulocavalcante.unichristusteste.enums.Turno;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
    private Usuario usuario;

    @NotNull
    private Veiculo veiculo;

    @NotNull
    private Destino destino;
}
