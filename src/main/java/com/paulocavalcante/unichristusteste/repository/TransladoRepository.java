package com.paulocavalcante.unichristusteste.repository;

import com.paulocavalcante.unichristusteste.entity.Translado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransladoRepository extends JpaRepository<Translado, Long> {
}
