package br.gustavo.hemburguer.entity.repository;

import br.gustavo.hemburguer.entity.table_pedido.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepositoy extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByUser(Long user);

    void deleteByUser(Long id);
}
