package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.Exceptions.DuplicidadeException;
import com.paulocavalcante.unichristusteste.entity.Translado;
import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.repository.DestinoRepository;
import com.paulocavalcante.unichristusteste.repository.TransladoRepository;
import com.paulocavalcante.unichristusteste.repository.UsuarioRepository;
import com.paulocavalcante.unichristusteste.repository.VeiculoRepository;
import com.paulocavalcante.unichristusteste.request.TransladoRequestSimplificado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransladoService {

    @Autowired
    private TransladoRepository transladoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Translado cadastraTranslado(Translado response) {
        var transladosExistentes = transladoRepository.findAll();

        var usuarioTRansladoCadastrado = transladosExistentes.stream().filter(usuario -> usuario.getUsuario().getId() == response.getUsuario().getId()).collect(Collectors.toList());


        if(!usuarioTRansladoCadastrado.isEmpty())
            for (Translado translado : transladosExistentes) {
                if (((response.getDataDesejada().isEqual(translado.getDataDesejada()) && (response.getTurno().equals(translado.getTurno()))))) {
                    throw new DuplicidadeException("Você já selecionou um translado para esta data desejada e turno com o mesmo destino");
                }
            }

        return transladoRepository.save(response);
    }

    public List<Translado> buscaTranslados() {
        return transladoRepository.findAll();
    }
}
