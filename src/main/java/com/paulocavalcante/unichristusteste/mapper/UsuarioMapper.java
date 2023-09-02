package com.paulocavalcante.unichristusteste.mapper;

import com.paulocavalcante.unichristusteste.entity.Usuario;
import com.paulocavalcante.unichristusteste.enums.Role;
import com.paulocavalcante.unichristusteste.request.UsuarioRequest;
import com.paulocavalcante.unichristusteste.response.UsuarioResponse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public static Usuario requestToModel(UsuarioRequest usuarioRequest) {
        return Usuario
                .builder()
                .nome(usuarioRequest.getNome())
                .email(usuarioRequest.getEmail())
                .senha(usuarioRequest.getSenha())
                .role(Role.valueOf(usuarioRequest.getRole().toString()))
                .build();

    }

    public static UsuarioResponse modelToResponse(Usuario usuario) {
        return UsuarioResponse
                .builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .role(Role.valueOf(usuario.getRole().toString()))
                .build();
    }

    public static List<UsuarioResponse> modelToResponseList(List<Usuario> usuarios) {
        if (Objects.isNull(usuarios)) {
            return new ArrayList<>();
        } else {
            return usuarios.stream().map(UsuarioMapper::modelToResponse).collect(Collectors.toList());
        }

    }
}
