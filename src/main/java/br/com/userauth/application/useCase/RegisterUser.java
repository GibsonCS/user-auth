package br.com.userauth.application.useCase;

import br.com.userauth.application.ports.out.PasswordEncoder;
import br.com.userauth.application.ports.out.RoleRepository;
import br.com.userauth.application.ports.out.UserRepository;
import br.com.userauth.domain.entities.role.Role;
import br.com.userauth.domain.entities.user.User;
import br.com.userauth.domain.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUser {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User execute(String login, String email, String password) {

        User userFounded = userRepository.findByEmail(email);

        if (userFounded != null) {
            throw new UserAlreadyExistException("User already exist");
        }


        Role role = roleRepository.findByName("USER");

        Set<Role> roles = new HashSet<>();

        roles.add(role);

        User user = new User(
                UUID.randomUUID().toString(),
                login,
                email,
                passwordEncoder.encode(password),
                true,
                roles
        );

        userRepository.save(user);

        return user;
    }
}
