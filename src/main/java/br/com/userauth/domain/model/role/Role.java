package br.com.userauth.domain.model.role;

import lombok.Getter;

@Getter
public class Role {

    private final String id;
    private final String roleName;

    public Role(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
