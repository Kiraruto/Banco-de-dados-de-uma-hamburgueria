package br.gustavo.hemburguer.entity.table_pedido.service;

import br.gustavo.hemburguer.entity.repository.EnderecoRepositoy;
import br.gustavo.hemburguer.entity.repository.PerfilRepository;
import br.gustavo.hemburguer.entity.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity.table_pedido.Perfil;
import br.gustavo.hemburguer.entity.table_pedido.Usuario;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPerfil;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOUsuairo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final BCryptPasswordEncoder cpfEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private EnderecoRepositoy enderecoRepositoy;

    public String hashPassWords(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    public String hashCpf(String plainCpf) {
        return cpfEncoder.encode(plainCpf);
    }

    @Transactional
    public ResponseEntity saveUser(@Valid DTOUsuairo dtoUsuairo) {

        String hashedPassword = hashPassWords(dtoUsuairo.password());
        String hashedCpf = hashCpf(dtoUsuairo.cpf());

        if (usuarioRepository.existsByEmail(dtoUsuairo.email())) {
            return ResponseEntity.badRequest().body("Já existe um perfil com este EMAIL");
        }

        Usuario usuario = new Usuario(dtoUsuairo.name(), dtoUsuairo.email(), hashedCpf, hashedPassword);
        usuario.setRoleUser();
        usuarioRepository.save(usuario);
        perfilRepository.save(new Perfil(dtoUsuairo));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity saveModerator(@Valid DTOUsuairo dtoUsuairo) {
        String hashedPassword = hashPassWords(dtoUsuairo.password());
        String hashedCpf = hashCpf(dtoUsuairo.cpf());

        if (usuarioRepository.existsByEmail(dtoUsuairo.email())) {
            return ResponseEntity.badRequest().body("Já existe um perfil com este EMAIL");
        }

        Usuario usuario = new Usuario(dtoUsuairo.name(), dtoUsuairo.email(), hashedCpf, hashedPassword);
        usuario.setRoleModerator();
        usuarioRepository.save(usuario);
        perfilRepository.save(new Perfil(dtoUsuairo));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity verTodosUsuariosTable() {
        var savePerfis = perfilRepository.findAll();
        var saveDTOPerfis = DTOPerfil.fromPerfilList(savePerfis);

        return ResponseEntity.ok(saveDTOPerfis);
    }

    public ResponseEntity deletarUsuarioPeloId(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);
        enderecoRepositoy.deleteByUser(id);

        return ResponseEntity.noContent().build();
    }
}
