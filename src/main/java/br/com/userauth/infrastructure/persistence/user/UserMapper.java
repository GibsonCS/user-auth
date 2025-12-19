package br.com.userauth.infrastructure.persistence.user;

import br.com.userauth.domain.entities.role.Role;
import br.com.userauth.domain.entities.user.User;
import br.com.userauth.infrastructure.persistence.role.RoleEntity;
import br.com.userauth.infrastructure.persistence.role.RoleMapper;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        Set<RoleEntity> roles = user.getRoles()
                .stream()
                .map(RoleMapper::toEntity)
                .collect(Collectors.toSet());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setLogin(user.getLogin());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setActive(user.getActive());
        userEntity.setRoles(roles);

        return userEntity;
    }

    public static User toDomain(UserEntity userEntity) {
        Set<Role> roles = userEntity
                .getRoles()
                .stream()
                .map(RoleMapper::toDomain)
                .collect(Collectors.toSet());

        return new User(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getActive(),
                roles
        );
    }
}
