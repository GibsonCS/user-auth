package br.com.userauth.domain.entities.user;

import br.com.userauth.domain.entities.role.Role;
import br.com.userauth.domain.exception.InvalidEmailException;
import br.com.userauth.domain.exception.InvalidLoginException;
import br.com.userauth.domain.exception.InvalidPasswordException;
import br.com.userauth.domain.exception.RoleAlreadyExistsException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class User {

    private final String id;
    private final String login;
    private final String email;
    private final String password;
    private final Boolean active;
    private Set<Role> roles = new HashSet<>();

    public User(String id, String login, String email, String password, Boolean active) {
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
        this.active = active;
    }

    public void addRole(Role role) {
        if (this.roles.stream().anyMatch(r -> r.getId().equals(role.getId()))) {
            throw new RoleAlreadyExistsException("Role already exists!");
        }

        this.roles.add(role);
    }
}
