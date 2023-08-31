package com.paulocavalcante.unichristusteste.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import com.paulocavalcante.unichristusteste.repository.UsuarioRepository;
import com.paulocavalcante.unichristusteste.request.AutheticationRequest;
import com.paulocavalcante.unichristusteste.response.AuthenticationResponse;

public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticationResponse(AutheticationRequest request) {
        var user = usuarioRepository.findByLogin(request.getLogin());

        var jwtToken = jwtService.generateTokenUser(user);
        
        var token = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    
}
