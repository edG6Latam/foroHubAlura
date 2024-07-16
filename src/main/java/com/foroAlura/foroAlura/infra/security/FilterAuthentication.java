package com.foroAlura.foroAlura.infra.security;

import com.foroAlura.foroAlura.domain.repository.RepositoryUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterAuthentication extends OncePerRequestFilter {

    private TokenService tokenService;
    private RepositoryUsuario repositoryUsuario;

    public FilterAuthentication(TokenService tokenService, RepositoryUsuario repositoryUsuario) {
        this.tokenService = tokenService;
        this.repositoryUsuario=repositoryUsuario;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var autToken=request.getHeader("Authorization");
        if(autToken!=null){
            var token=autToken.replace("Bearer ","");
            var subject=tokenService.getSubject(token);
            if(subject!=null){
                var usuario=repositoryUsuario.findByLogin(subject);
                var autenticar= new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticar);
            }
        }
        filterChain.doFilter(request,response);
    }
}
