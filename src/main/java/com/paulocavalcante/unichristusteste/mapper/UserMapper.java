package com.paulocavalcante.unichristusteste.mapper;

import com.paulocavalcante.unichristusteste.entity.User;
import com.paulocavalcante.unichristusteste.enums.Role;
import com.paulocavalcante.unichristusteste.request.UserRequest;
import com.paulocavalcante.unichristusteste.response.UsuarioResponse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public static User requestToModel(UserRequest userRequest) {
        return User
                .builder()
                .nome(userRequest.getNome())
                .email(userRequest.getEmail())
                .senha(userRequest.getSenha())
                .role(Role.valueOf(userRequest.getRole().toString()))
                .build();

    }

    public static UsuarioResponse modelToResponse(User user) {
        return UsuarioResponse
                .builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .senha(user.getSenha())
                .role(Role.valueOf(user.getRole().toString()))
                .build();
    }

    public static List<UsuarioResponse> modelToResponseList(List<User> users) {
        if (Objects.isNull(users)) {
            return new ArrayList<>();
        } else {
            return users.stream().map(UserMapper::modelToResponse).collect(Collectors.toList());
        }

    }
}
