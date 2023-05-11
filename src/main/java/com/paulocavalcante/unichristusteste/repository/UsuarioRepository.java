package com.paulocavalcante.unichristusteste.repository;

import com.paulocavalcante.unichristusteste.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
