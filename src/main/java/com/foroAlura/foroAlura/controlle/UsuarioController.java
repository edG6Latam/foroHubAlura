package com.foroAlura.foroAlura.controlle;

import com.foroAlura.foroAlura.domain.model.usuario.DatosUsuario;
import com.foroAlura.foroAlura.domain.model.usuario.Usuario;
import com.foroAlura.foroAlura.infra.security.DatosToken;
import com.foroAlura.foroAlura.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public UsuarioController(AuthenticationManager authenticationManager,TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService= tokenService;
    }

    @PostMapping
    public ResponseEntity loguearse(@RequestBody @Valid DatosUsuario datosUsuario){
        Authentication autToken=new UsernamePasswordAuthenticationToken(datosUsuario.login(),datosUsuario.clave());
        var usuario=authenticationManager.authenticate(autToken);
        var token=tokenService.getToken((Usuario) usuario.getPrincipal());
        return ResponseEntity.ok(new DatosToken(token));
    }

}
