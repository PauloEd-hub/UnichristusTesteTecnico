package com.paulocavalcante.unichristusteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulocavalcante.unichristusteste.config.service.AuthService;
import com.paulocavalcante.unichristusteste.request.AutheticationRequest;
import com.paulocavalcante.unichristusteste.response.AuthenticationResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @PostMapping()
    public AuthenticationResponse auth(@RequestBody AutheticationRequest request){
        return authService.authenticationResponse(request);

    }
}
