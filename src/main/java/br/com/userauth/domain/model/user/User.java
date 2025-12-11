package br.com.userauth.domain.model;

import br.com.userauth.domain.exception.InvalidEmailException;
import br.com.userauth.domain.exception.InvalidLoginException;
import br.com.userauth.domain.exception.InvalidPasswordException;
import br.com.userauth.infrastructure.persistence.Role;
import lombok.Getter;

import java.util.Set;

@Getter
public class User {

    private final String id;
    private final String login;
    private final String email;
    private final String password;
    private final Set<Role> roles;

    public User(String id, String login, String email, String password, Set<Role> roles) {
        if (login == null || login.length() <= 3) {
            throw new InvalidLoginException("insert a valid login");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailException("insert a valid email");
        }
        if (password == null || password.length() <= 6) {
            throw new InvalidPasswordException("password must be contain  6 or more characters");
        }

        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = Set.copyOf(roles);
    }


}
