package br.gustavo.hemburguer.entity_tables.table_pedido.service;

import br.gustavo.hemburguer.entity_tables.repository.PerfilRepository;
import br.gustavo.hemburguer.entity_tables.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity_tables.table_pedido.Perfil;
import br.gustavo.hemburguer.entity_tables.table_pedido.Usuario;
import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOUsuairo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final BCryptPasswordEncoder cpfEncoder = new BCryptPasswordEncoder();

    public String hashPassWords(String plainPassword){
        return passwordEncoder.encode(plainPassword);
    }

    public String hashCpf(String plainCpf){
        return cpfEncoder.encode(plainCpf);
    }

    @Transactional
    public ResponseEntity save(@Valid DTOUsuairo dtoUsuairo) {

        String hashedPassword = hashPassWords(dtoUsuairo.password());
        String hashedCpf = hashCpf(dtoUsuairo.cpf());

        Usuario usuario = new Usuario(dtoUsuairo.name(), dtoUsuairo.email(), hashedCpf, hashedPassword);
        usuarioRepository.save(usuario);
        perfilRepository.save(new Perfil(dtoUsuairo));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
