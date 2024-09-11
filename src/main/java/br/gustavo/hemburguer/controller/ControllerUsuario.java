package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.repository.EnderecoRepositoy;
import br.gustavo.hemburguer.entity.repository.PerfilRepository;
import br.gustavo.hemburguer.entity.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOUsuairo;
import br.gustavo.hemburguer.entity.table_pedido.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private EnderecoRepositoy enderecoRepositoy;

    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@Valid @RequestBody DTOUsuairo dtoUsuairo) {
        return usuarioService.saveUser(dtoUsuairo);
    }

    @PostMapping("/moderator")
    @Transactional
    public ResponseEntity criarUsuarioModerator(@Valid @RequestBody DTOUsuairo dtoUsuario) {
        return usuarioService.saveModerator(dtoUsuario);
    }

    @GetMapping
    public ResponseEntity verTodosUsuarios() {

        return usuarioService.verTodosUsuariosTable();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id) {

        return usuarioService.deletarUsuarioPeloId(id);
    }
}
