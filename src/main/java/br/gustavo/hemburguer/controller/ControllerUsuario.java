package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity_tables.repository.EnderecoRepositoy;
import br.gustavo.hemburguer.entity_tables.repository.PerfilRepository;
import br.gustavo.hemburguer.entity_tables.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity_tables.table_pedido.Usuario;
import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOPerfil;
import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOUsuairo;
import br.gustavo.hemburguer.entity_tables.table_pedido.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        return usuarioService.save(dtoUsuairo);
    }

    @GetMapping
    public ResponseEntity verTodosUsuarios() {

        var savePerfis = perfilRepository.findAll();
        var saveDTOPerfis = DTOPerfil.fromPerfilList(savePerfis);

        return ResponseEntity.ok(saveDTOPerfis);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);
        enderecoRepositoy.deleteByUser(id);

        return ResponseEntity.noContent().build();
    }

}