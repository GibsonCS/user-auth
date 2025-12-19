package br.com.userauth.infrastructure.persistence.user;

import br.com.userauth.application.ports.out.UserRepository;
import br.com.userauth.domain.entities.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);

        userJpaRepository.save(userEntity);
    }

    @Override
    public void softDelete(User user) {
        Optional<UserEntity> entity = userJpaRepository.findById(UserMapper.toEntity(user).getId());

        entity.ifPresent(userEntity -> userEntity.setActive(false));

        entity.ifPresent(userJpaRepository::save);
    }

    @Override
    public UserDetails findByLogin(String login) {
        return userJpaRepository.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = userJpaRepository.findByEmail(email);

        if (userEntity != null) {
            return UserMapper.toDomain(userEntity);
        }

        return null;
    }

    @Override
    public User findById(String id) {
        Optional<UserEntity> entity = userJpaRepository.findById(id);

        return entity.map(UserMapper::toDomain).orElse(null);
    }
}
