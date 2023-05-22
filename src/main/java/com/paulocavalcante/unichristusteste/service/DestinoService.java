package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.repository.DestinoRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DestinoRepository destinoRepository;


    public Destino cadastraDestino(Destino response) {

        return destinoRepository.save(response);
    }

    public List<Destino> destinosCadastrados() {
        return destinoRepository.findAll();
    }

    public Destino buscaDestino(Long id) {
        return destinoRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Destino não encontrado"));
    }

    public void deletaDestino(Long id) {
        destinoRepository.deleteById(id);
    }
}
