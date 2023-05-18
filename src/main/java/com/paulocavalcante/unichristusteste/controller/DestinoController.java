package com.paulocavalcante.unichristusteste.controller;

import com.paulocavalcante.unichristusteste.mapper.DestinoMapper;
import com.paulocavalcante.unichristusteste.request.DestinoRequest;
import com.paulocavalcante.unichristusteste.response.DestinoResponse;
import com.paulocavalcante.unichristusteste.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping("/cadastro")
    public DestinoResponse cadastraDestino(@RequestBody DestinoRequest destinoRequest) {
        var response = DestinoMapper.requestToModel(destinoRequest);

        return DestinoMapper.modelToResponse(destinoService.cadastraDestino(response));

    }
}
