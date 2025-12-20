package br.com.userauth.domain.entities.role;

import lombok.Getter;

@Getter
public class Role {

    private final Integer id;
    private final String roleName;

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
