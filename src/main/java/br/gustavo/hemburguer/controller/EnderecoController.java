package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOEndereco;
import br.gustavo.hemburguer.entity.table_pedido.service.EnderecoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @Transactional
    public ResponseEntity adicionarEndereco(@RequestBody @Valid DTOEndereco dtoEndereco) {

        return enderecoService.save(dtoEndereco);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarEndereco(@RequestBody @Valid DTOEndereco dtoEndereco, @PathVariable Long id) {

        return enderecoService.put(dtoEndereco, id);
    }
}
