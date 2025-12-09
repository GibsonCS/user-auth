package br.com.userauth.domain.repository;

import br.com.userauth.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    public void save(User user);

    public UserDetails findByLogin(String login);

    public User findByEmail(String email);
}
