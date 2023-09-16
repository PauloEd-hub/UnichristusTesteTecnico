package com.paulocavalcante.unichristusteste.service;

import com.paulocavalcante.unichristusteste.Exceptions.DataAlreadyRegisterException;
import com.paulocavalcante.unichristusteste.entity.User;
import com.paulocavalcante.unichristusteste.repository.UserRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> usuariosCadastrados() {
        return userRepository.findAll();
    }

    public User cadastraUsuario(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new DataAlreadyRegisterException("Já existe um usuário com este email!");
        }

        String senhaEncoded = passwordEncoder.encode(user.getSenha());

        user.setSenha(senhaEncoded);

        return userRepository.save(user);
    }

    public User buscaUsuario(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Usuário não encontrado"));
    }

    public void deletaUsuario(Long id) {

         userRepository.deleteById(id);
    }
}
