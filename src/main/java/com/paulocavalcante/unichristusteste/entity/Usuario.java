package com.paulocavalcante.unichristusteste.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.paulocavalcante.unichristusteste.enums.TipoDeUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario  implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario;

    @JsonBackReference
    @OneToMany(mappedBy = "usuario")
    private Translado translados;


    @Override
    public String getPassword() {
       return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority(tipoDeUsuario.name()));
    }

}
