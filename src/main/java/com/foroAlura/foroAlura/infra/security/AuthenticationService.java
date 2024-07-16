package com.foroAlura.foroAlura.infra.security;

import com.foroAlura.foroAlura.domain.repository.RepositoryUsuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private RepositoryUsuario repositoryUsuario;

    public AuthenticationService(RepositoryUsuario repositoryUsuario) {
        this.repositoryUsuario = repositoryUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUsuario.findByLogin(username);
    }
}
