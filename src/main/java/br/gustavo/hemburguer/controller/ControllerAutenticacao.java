package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity.table_pedido.Usuario;
import br.gustavo.hemburguer.entity.table_pedido.enumclass.Role;
import br.gustavo.hemburguer.security.TokenService;
import br.gustavo.hemburguer.security.dto.DadosAutenticacao;
import br.gustavo.hemburguer.security.dto.TokenDadosJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ControllerAutenticacao {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = manager.authenticate(authenticationToken);

        var usuario = (Usuario) authentication.getPrincipal();

        if (usuario.getRole() != Role.ROLE_MODERATOR) {
            return ResponseEntity.badRequest().body("O usuário não é moderador");
        }

        var tokenJWT = tokenService.gerarToke(usuario);
        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT));
    }
}