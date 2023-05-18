package com.paulocavalcante.unichristusteste.controller;

import com.paulocavalcante.unichristusteste.mapper.VeiculoMapper;
import com.paulocavalcante.unichristusteste.request.VeiculoRequest;
import com.paulocavalcante.unichristusteste.response.VeiculoResponse;
import com.paulocavalcante.unichristusteste.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/cadastro")
    public VeiculoResponse cadastraVeiculo(@RequestBody VeiculoRequest veiculoRequest) {
        var response = VeiculoMapper.requestToModel(veiculoRequest);

        return VeiculoMapper.modelToResponse(veiculoService.cadastraVeiculo(response));
    }
}
