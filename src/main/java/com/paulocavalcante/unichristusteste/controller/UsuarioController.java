package com.paulocavalcante.unichristusteste.controller;


import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.mapper.UsuarioMapper;
import com.paulocavalcante.unichristusteste.request.UsuarioRequest;
import com.paulocavalcante.unichristusteste.response.UsuarioResponse;
import com.paulocavalcante.unichristusteste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public UsuarioResponse cadastraUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        var response = UsuarioMapper.requestToModel(usuarioRequest);

        return UsuarioMapper.modelToResponse(usuarioService.cadastraUsuario(response));
    }
}
