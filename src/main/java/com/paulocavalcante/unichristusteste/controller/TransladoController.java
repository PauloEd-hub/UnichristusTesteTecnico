package com.paulocavalcante.unichristusteste.controller;

import com.paulocavalcante.unichristusteste.mapper.TransladoMapper;
import com.paulocavalcante.unichristusteste.request.TransladoRequest;
import com.paulocavalcante.unichristusteste.request.TransladoRequestSimplificado;
import com.paulocavalcante.unichristusteste.response.TransladoResponse;
import com.paulocavalcante.unichristusteste.service.DestinoService;
import com.paulocavalcante.unichristusteste.service.TransladoService;
import com.paulocavalcante.unichristusteste.service.UsuarioService;
import com.paulocavalcante.unichristusteste.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/translado")
public class TransladoController {

    @Autowired
    private TransladoService transladoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DestinoService destinoService;

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public TransladoResponse cadastraTranslado(@RequestBody TransladoRequestSimplificado transladoRequestSimplificado) {
        var usuario = usuarioService.buscaUsuario(transladoRequestSimplificado.getId_usuario());

        var veiculo = veiculoService.buscaVeiculo(transladoRequestSimplificado.getId_veiculo());

        var destino = destinoService.buscaDestino(transladoRequestSimplificado.getId_destino());



         var response = TransladoMapper.simplificadoToModel(transladoRequestSimplificado, usuario, destino, veiculo);

         return  TransladoMapper.modelToResponse(transladoService.cadastraTranslado(response));


    }

    @GetMapping
    public List<TransladoResponse> buscaTranslados() {
        return TransladoMapper.modelToResponseList(transladoService.buscaTranslados());
    }
}
