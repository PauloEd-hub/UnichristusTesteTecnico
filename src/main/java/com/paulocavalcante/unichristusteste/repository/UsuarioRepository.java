package com.paulocavalcante.unichristusteste.repository;

import com.paulocavalcante.unichristusteste.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByLogin(String login);
}
