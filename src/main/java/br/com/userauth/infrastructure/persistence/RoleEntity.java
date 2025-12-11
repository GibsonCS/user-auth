package br.com.userauth.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "roles")
@Entity
@Data
public class RoleEntity {

    @Id
    private String id;
    @Column(name = "role_name")
    private String roleName;
}
