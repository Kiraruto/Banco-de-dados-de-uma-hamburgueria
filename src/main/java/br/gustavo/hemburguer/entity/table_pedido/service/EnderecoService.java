package br.gustavo.hemburguer.entity.table_pedido.service;

import br.gustavo.hemburguer.entity.repository.EnderecoRepositoy;
import br.gustavo.hemburguer.entity.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity.table_pedido.Endereco;
import br.gustavo.hemburguer.entity.table_pedido.Usuario;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOEndereco;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepositoy enderecoRepositoy;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity save(DTOEndereco dtoEndereco) {

        Optional<Endereco> existingEndereco = enderecoRepositoy.findByUser(dtoEndereco.user());

        if (existingEndereco.isPresent()) {
            return ResponseEntity.badRequest().body("Já existe um endereço cadastrado para este usuário");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dtoEndereco.user());

        if (usuarioOptional.isPresent()) {
            Endereco endereco = new Endereco(dtoEndereco);

            enderecoRepositoy.save(endereco);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("Não exixte usuário com este Id");
    }

    @Transactional
    public ResponseEntity put(@Valid DTOEndereco dtoEndereco, Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepositoy.findById(id);

        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Endereço não Encontrado");
        }

        var endereco = enderecoRepositoy.getReferenceById(dtoEndereco.user());
        endereco.atualizarInformacoes(dtoEndereco);

        return ResponseEntity.ok(new DTOEndereco(endereco));
    }
}
