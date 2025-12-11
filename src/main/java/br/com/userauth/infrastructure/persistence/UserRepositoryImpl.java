package br.com.userauth.infrastructure.persistence;

import br.com.userauth.domain.model.user.User;
import br.com.userauth.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

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
    public UserDetails findByLogin(String login) {
        return userJpaRepository.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = userJpaRepository.findByEmail(email);

        if (userEntity != null) {
            return UserMapper.toDomain(userEntity);
        } else {
            return null;
        }
    }
}
