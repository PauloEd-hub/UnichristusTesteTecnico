package com.paulocavalcante.unichristusteste.response;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.entity.Veiculo;
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

    private LocalDate dataDesejada;

    private char turno;

    private Usuario usuario;

    private Veiculo veiculo;

    private Destino destino;
}
