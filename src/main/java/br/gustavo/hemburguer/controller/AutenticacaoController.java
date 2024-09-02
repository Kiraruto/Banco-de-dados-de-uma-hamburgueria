package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity_tables.table_pedido.Usuario;
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
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToke((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT));
    }
}