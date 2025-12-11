package br.com.userauth.infrastructure.persistence;

import br.com.userauth.domain.model.role.Role;
import br.com.userauth.domain.model.user.User;

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
                roles
        );
    }
}
