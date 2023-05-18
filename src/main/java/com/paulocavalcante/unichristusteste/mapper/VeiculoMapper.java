package com.paulocavalcante.unichristusteste.mapper;

import com.paulocavalcante.unichristusteste.entity.Veiculo;
import com.paulocavalcante.unichristusteste.request.VeiculoRequest;
import com.paulocavalcante.unichristusteste.response.VeiculoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VeiculoMapper {

    public static Veiculo requestToModel(VeiculoRequest veiculoRequest) {
        return Veiculo
                .builder()
                .descricao(veiculoRequest.getDescricao())
                .ocupacaoMaxima(veiculoRequest.getOcupacaoMaxima())
                .build();
    }

    public static VeiculoResponse modelToResponse(Veiculo veiculo) {
        return VeiculoResponse
                .builder()
                .id(veiculo.getId())
                .descricao(veiculo.getDescricao())
                .ocupacaoMaxima(veiculo.getOcupacaoMaxima())
                .build();
    }

    public static List<VeiculoResponse> modelToResponseList(List<Veiculo> veiculos) {
        if (Objects.isNull(veiculos)) {
            return new ArrayList<>();
        } else {
            return veiculos.stream().map(VeiculoMapper::modelToResponse).collect(Collectors.toList());
        }

    }
}
