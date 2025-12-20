package br.com.userauth.infrastructure.http.controller;

import br.com.userauth.application.ports.in.AddRole;
import br.com.userauth.application.useCase.DeactivateUser;
import br.com.userauth.application.useCase.RegisterUser;
import br.com.userauth.domain.entities.user.User;
import br.com.userauth.infrastructure.http.dto.RegisterUserRequest;
import br.com.userauth.infrastructure.http.dto.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUser registerUser;
    private final DeactivateUser deactivateUser;
    private final AddRole addRole;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> handleRegister(@RequestBody RegisterUserRequest dto) {

        User userRegistered = registerUser.execute(dto.login(), dto.email(), dto.password());

        return ResponseEntity.status(201).body(new RegisterUserResponse(userRegistered.getId()));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<?> handleInactivateUser(@PathVariable String id) {

        deactivateUser.deactivateUser(id);

        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<?> handleAddUserRole(@PathVariable String userId, @PathVariable String roleId) {

        addRole.execute(userId, parseInt(roleId));

        return ResponseEntity.noContent().build();
    }
}
