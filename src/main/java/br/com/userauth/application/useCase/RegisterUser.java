package br.com.userauth.application.useCase;

import br.com.userauth.domain.exception.UserAlreadyExistException;
import br.com.userauth.domain.model.User;
import br.com.userauth.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUser {

    private final UserRepository userRepository;

    public User execute(String login, String email, String password) {

        User userFounded = userRepository.findByEmail(email);

        if (userFounded != null) {
            throw new UserAlreadyExistException("User already exist");
        }

        User user = new User(
                UUID.randomUUID().toString(),
                login,
                email,
                password
        );

        userRepository.save(user);

        return user;
    }
}
