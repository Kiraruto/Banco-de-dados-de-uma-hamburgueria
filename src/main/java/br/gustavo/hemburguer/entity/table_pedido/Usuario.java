package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.enumclass.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static br.gustavo.hemburguer.entity.table_pedido.enumclass.Role.ROLE_MODERATOR;
import static br.gustavo.hemburguer.entity.table_pedido.enumclass.Role.ROLE_USER;

@Entity(name = "usuario")
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Usuario(@NotNull String name, @NotNull @Email String email, String hashedCpf, String hashedPassword) {
        this.name = name;
        this.email = email;
        this.cpf = hashedCpf;
        this.password = hashedPassword;
    }

    public void setRoleUser() {
        this.role = ROLE_USER;
    }

    public void setRoleModerator() {
        this.role = ROLE_MODERATOR;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("MODERATOR"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
