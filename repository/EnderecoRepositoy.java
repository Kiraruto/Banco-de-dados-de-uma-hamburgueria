package br.gustavo.hemburguer.entity_tables.repository;

import br.gustavo.hemburguer.entity_tables.table_pedido.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepositoy extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByUser(Long user);

    void deleteByUser(Long id);
}
