package com.paulocavalcante.unichristusteste.mapper;

import com.paulocavalcante.unichristusteste.entity.Translado;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.request.TransladoRequest;
import com.paulocavalcante.unichristusteste.response.TransladoResponse;
import com.paulocavalcante.unichristusteste.response.UsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TransladoMapper {

    public static Translado requestToModel(TransladoRequest transladoRequest) {
        return Translado
                .builder()
                .dataDesejada(transladoRequest.getDataDesejada())
                .turno(transladoRequest.getTurno())
                .veiculo(transladoRequest.getVeiculo())
                .destino(transladoRequest.getDestino())
                .build();
    }

    public static TransladoResponse modelToResponse(Translado translado) {
        return TransladoResponse
                .builder()
                .id(translado.getId())
                .dataDesejada(translado.getDataDesejada())
                .turno(translado.getTurno())
                .usuario(translado.getUsuario())
                .veiculo(translado.getVeiculo())
                .destino(translado.getDestino())
                .build();
    }


    public static List<TransladoResponse> modelToResponseList(List<Translado> translados) {
        if (Objects.isNull(translados)) {
            return new ArrayList<>();
        } else {
            return translados.stream().map(TransladoMapper::modelToResponse).collect(Collectors.toList());
        }

    }
}
