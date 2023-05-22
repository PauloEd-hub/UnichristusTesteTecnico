package com.paulocavalcante.unichristusteste.controller;

import com.paulocavalcante.unichristusteste.mapper.VeiculoMapper;
import com.paulocavalcante.unichristusteste.request.VeiculoRequest;
import com.paulocavalcante.unichristusteste.response.VeiculoResponse;
import com.paulocavalcante.unichristusteste.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoResponse> veiculosCadastrados() {
        return VeiculoMapper.modelToResponseList(veiculoService.veiculosCadastrados());
    }

    @PostMapping("/cadastro")
    public VeiculoResponse cadastraVeiculo(@RequestBody VeiculoRequest veiculoRequest) {
        var response = VeiculoMapper.requestToModel(veiculoRequest);

        return VeiculoMapper.modelToResponse(veiculoService.cadastraVeiculo(response));
    }

    @GetMapping("/{id}")
    public VeiculoResponse buscaVeiculo(@PathVariable Long id) {
        return VeiculoMapper.modelToResponse(veiculoService.buscaVeiculo(id));

    }


}
