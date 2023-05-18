package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
