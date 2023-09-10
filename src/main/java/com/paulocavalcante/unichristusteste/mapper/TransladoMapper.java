package com.paulocavalcante.unichristusteste.mapper;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.Translado;
import com.paulocavalcante.unichristusteste.entity.User;
import com.paulocavalcante.unichristusteste.entity.Veiculo;
import com.paulocavalcante.unichristusteste.enums.Turno;
import com.paulocavalcante.unichristusteste.request.TransladoRequest;
import com.paulocavalcante.unichristusteste.request.TransladoRequestSimplificado;
import com.paulocavalcante.unichristusteste.response.TransladoResponse;
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
                .id(transladoRequest.getId())
                .dataDesejada(transladoRequest.getDataDesejada())
                .turno(Turno.valueOf(transladoRequest.getTurno().toString()))
                .veiculo(transladoRequest.getVeiculo())
                .destino(transladoRequest.getDestino())
                .build();
    }

    public static TransladoResponse modelToResponse(Translado translado) {
        return TransladoResponse
                .builder()
                .id(translado.getId())
                .dataDesejada(translado.getDataDesejada())
                .turno(Turno.valueOf(translado.getTurno().toString()))
                .user(translado.getUser())
                .veiculo(translado.getVeiculo())
                .destino(translado.getDestino())
                .build();
    }

    public static  Translado simplificadoToModel(TransladoRequestSimplificado transladoRequestSimplificado,
                                                 User user, Destino destino, Veiculo veiculo) {
        return Translado
                .builder()
                .dataDesejada(transladoRequestSimplificado.getDataDesejada())
                .turno(Turno.valueOf(transladoRequestSimplificado.getTurno().toString()))
                .user(user)
                .destino(destino)
                .veiculo(veiculo)
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
