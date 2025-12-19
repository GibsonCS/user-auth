package br.com.userauth.infrastructure.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    public UserDetails findByLogin(String login);

    public UserEntity findByEmail(String email);
}
