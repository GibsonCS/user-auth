package br.com.userauth.application.useCase;

import br.com.userauth.application.ports.UserRepository;
import br.com.userauth.domain.entities.user.User;
import br.com.userauth.domain.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeactivateUser implements br.com.userauth.application.ports.in.DeactivateUser {

    private final UserRepository userRepository;

    @Override
    public void deactivateUser(String id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new UserNotExistException("User not exists!");
        }

        userRepository.softDelete(user);
    }
}
