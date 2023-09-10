package com.paulocavalcante.unichristusteste.controller;


import com.paulocavalcante.unichristusteste.mapper.UserMapper;
import com.paulocavalcante.unichristusteste.response.UsuarioResponse;
import com.paulocavalcante.unichristusteste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping //Mostra todos os usuários cadastrados
    public List<UsuarioResponse> usuariosCadastrados() {
        return UserMapper.modelToResponseList(usuarioService.usuariosCadastrados());
    }

    @GetMapping("/{id}") //Busca usuário por id
    public UsuarioResponse buscaUsuario(@PathVariable Long id) {
        return UserMapper.modelToResponse(usuarioService.buscaUsuario(id));

    }

    @DeleteMapping("/{id}") //Deleta usuário
    public void deletaUsuario(@PathVariable Long id) {
         usuarioService.deletaUsuario(id);
    }
}
