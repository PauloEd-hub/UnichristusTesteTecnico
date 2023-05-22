package com.paulocavalcante.unichristusteste.controller;

import com.paulocavalcante.unichristusteste.mapper.DestinoMapper;
import com.paulocavalcante.unichristusteste.request.DestinoRequest;
import com.paulocavalcante.unichristusteste.response.DestinoResponse;
import com.paulocavalcante.unichristusteste.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    private List<DestinoResponse> destinosCadastrados() {
        return DestinoMapper.modelToResponseList(destinoService.destinosCadastrados());
    }

    @PostMapping("/cadastro")
    public DestinoResponse cadastraDestino(@RequestBody DestinoRequest destinoRequest) {
        var response = DestinoMapper.requestToModel(destinoRequest);

        return DestinoMapper.modelToResponse(destinoService.cadastraDestino(response));
    }

    @GetMapping
    public DestinoResponse buscaDestino(@PathVariable Long id) {
        return DestinoMapper.modelToResponse(destinoService.buscaDestino(id));

    }

    @DeleteMapping
    public void deletaDestino(@PathVariable Long id) {
        destinoService.deletaDestino(id);

    }
}
