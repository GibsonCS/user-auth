package br.com.userauth.application.ports;

import br.com.userauth.domain.entities.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    public void save(User user);

    public void softDelete(User user);

    public UserDetails findByLogin(String login);

    public User findByEmail(String email);

    public User findById(String id);
}
