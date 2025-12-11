package br.com.userauth.infrastructure.persistence;

import br.com.userauth.domain.model.role.Role;

public class RoleMapper {

    public static Role toDomain(RoleEntity roleEntity) {
        return new Role(
                roleEntity.getId(),
                roleEntity.getRoleName()
        );
    }

    public static RoleEntity toEntity(Role role) {
        RoleEntity entity = new RoleEntity();

        entity.setId(role.getId());
        entity.setRoleName(role.getRoleName());

        return entity;
    }
}
