package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.entity.Destino;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DestinoRepository destinoRepository;


    public Destino cadastraDestino(Destino response) {

        return destinoRepository.save(response);
    }
}
