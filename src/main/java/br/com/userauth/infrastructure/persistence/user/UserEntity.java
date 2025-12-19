package br.com.userauth.infrastructure.persistence.user;

import br.com.userauth.infrastructure.persistence.role.RoleEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String id;

    private String login;
    private String email;
    private String password;
    private Boolean active;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "users_id"))
    private Set<RoleEntity> roles;
}
