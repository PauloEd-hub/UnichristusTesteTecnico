package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.entity.Veiculo;
import com.paulocavalcante.unichristusteste.repository.VeiculoRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastraVeiculo(Veiculo response) {
        return veiculoRepository.save(response);

    }

    public List<Veiculo> veiculosCadastrados() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscaVeiculo(Long id) {
        return veiculoRepository.findById(id).orElseThrow(() -> new NoResultException("Usuário não encontrado"));
    }
}
