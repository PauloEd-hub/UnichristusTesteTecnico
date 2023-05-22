package com.paulocavalcante.unichristusteste.controller;


import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.mapper.UsuarioMapper;
import com.paulocavalcante.unichristusteste.request.UsuarioRequest;
import com.paulocavalcante.unichristusteste.response.UsuarioResponse;
import com.paulocavalcante.unichristusteste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponse> usuariosCadastrados() {
        return UsuarioMapper.modelToResponseList(usuarioService.usuariosCadastrados());
    }

    @PostMapping("/cadastro")
    public UsuarioResponse cadastraUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        var response = UsuarioMapper.requestToModel(usuarioRequest);

        return UsuarioMapper.modelToResponse(usuarioService.cadastraUsuario(response));
    }

    @GetMapping("/{id}")
    public UsuarioResponse buscaUsuario(@PathVariable Long id) {
        return UsuarioMapper.modelToResponse(usuarioService.buscaUsuario(id));

    }

    @DeleteMapping("/{id}")
    public void deletaUsuario(@PathVariable Long id) {
         usuarioService.deletaUsuario(id);
    }
}
