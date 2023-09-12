package com.paulocavalcante.unichristusteste.config.service;

import com.paulocavalcante.unichristusteste.repository.UserRepository;
import com.paulocavalcante.unichristusteste.request.AutheticationRequest;
import com.paulocavalcante.unichristusteste.request.UserRequest;
import com.paulocavalcante.unichristusteste.response.AuthenticationResponse;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthenticationResponse auth(AutheticationRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoResultException("Usuário não encontrado"));

        var jwtToken = jwtService.generateToken(user);
        var token = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getSenha()));

        return token;
    }
}
