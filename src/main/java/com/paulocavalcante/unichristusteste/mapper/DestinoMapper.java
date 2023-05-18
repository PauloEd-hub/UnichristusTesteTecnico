package com.paulocavalcante.unichristusteste.mapper;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.request.DestinoRequest;
import com.paulocavalcante.unichristusteste.response.DestinoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DestinoMapper {

    public static Destino requestToModel(DestinoRequest destinoRequest) {
        return Destino
                .builder()
                .nome(destinoRequest.getNome())
                .sigla(destinoRequest.getSigla())
                .build();

    }

    public static DestinoResponse modelToResponse(Destino destino) {
        return DestinoResponse
                .builder()
                .id(destino.getId())
                .nome(destino.getNome())
                .sigla(destino.getSigla())
                .build();
    }

    public static List<DestinoResponse> modelToResponseList(List<Destino> destinos) {
        if (Objects.isNull(destinos)) {
            return new ArrayList<>();
        } else {
            return destinos.stream().map(DestinoMapper::modelToResponse).collect(Collectors.toList());
        }

    }

}
