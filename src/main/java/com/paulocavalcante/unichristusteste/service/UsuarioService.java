package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.repository.UsuarioRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> usuariosCadastrados() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastraUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscaUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Usuário não encontrado"));
    }

    public void deletaUsuario(Long id) {

         usuarioRepository.deleteById(id);
    }
}
