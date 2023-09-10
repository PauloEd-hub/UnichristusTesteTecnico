package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.Exceptions.CapacidadeMaximaExcedidaException;
import com.paulocavalcante.unichristusteste.Exceptions.DuplicidadeException;
import com.paulocavalcante.unichristusteste.entity.Translado;
import com.paulocavalcante.unichristusteste.repository.TransladoRepository;
import com.paulocavalcante.unichristusteste.repository.UserRepository;
import com.paulocavalcante.unichristusteste.repository.VeiculoRepository;
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
    private UserRepository userRepository;

    public Translado cadastraTranslado(Translado response) {
        var transladosExistentes = transladoRepository.findAll();
        var usuarioTransladoCadastrado = transladosExistentes.stream().filter(usuario -> usuario.getUser().getId() == response.getUser().getId()).collect(Collectors.toList());


        try {
            if (!usuarioTransladoCadastrado.isEmpty()) {
                for (Translado translado : transladosExistentes) {
                    if (((response.getDataDesejada().isEqual(translado.getDataDesejada()) && (response.getTurno().equals(translado.getTurno()))))) {
                        throw new DuplicidadeException("Não pode fazer a solicitação de Translado para destinos diferentes, " +
                                "quando  a data desejada e o turno já foram escolhidas.");
                    }
                }
            }
            var capacidadeAtual = response.getVeiculo().getOcupacaoMaxima();
            if (capacidadeAtual == 0) {
                throw new CapacidadeMaximaExcedidaException("O carro está lotado para esta data desejada, turno e destino");
            }
            capacidadeAtual -= 1;

            response.getVeiculo().setOcupacaoMaxima(capacidadeAtual);

        } catch (RuntimeException ex) {
            ex.printStackTrace();

        }

            return transladoRepository.save(response);
    }

    public List<Translado> buscaTranslados() {
        return transladoRepository.findAll();
    }
}
