package br.com.userauth.application.ports;

import br.com.userauth.domain.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    public void save(User user);

    public UserDetails findByLogin(String login);

    public User findByEmail(String email);
}
