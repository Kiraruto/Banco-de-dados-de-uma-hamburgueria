package br.gustavo.hemburguer.entity_tables.repository;

import br.gustavo.hemburguer.entity_tables.table_pedido.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);}
