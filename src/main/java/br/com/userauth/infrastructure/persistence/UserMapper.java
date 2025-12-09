package br.com.userauth.infrastructure.persistence;

import br.com.userauth.domain.model.User;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setLogin(user.getLogin());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }


    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }
}
