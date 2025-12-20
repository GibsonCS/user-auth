package br.com.userauth.application.useCase;

import br.com.userauth.application.ports.in.AddRole;
import br.com.userauth.application.ports.out.RoleRepository;
import br.com.userauth.application.ports.out.UserRepository;
import br.com.userauth.domain.entities.role.Role;
import br.com.userauth.domain.entities.user.User;
import br.com.userauth.domain.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddRoleUseCase implements AddRole {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void execute(String userId, Integer roleId) {

        User userFounded = userRepository.findById(userId);

        if (userFounded == null) {
            throw new UserNotExistException("User not exists!");
        }

        Role roleFounded = roleRepository.findById(roleId);
        userFounded.addRole(roleFounded);

        this.userRepository.save(userFounded);
    }
}
