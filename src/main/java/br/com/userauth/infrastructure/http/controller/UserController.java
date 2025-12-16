package br.com.userauth.infrastructure.http.controller;

import br.com.userauth.application.useCase.DeactivateUser;
import br.com.userauth.application.useCase.RegisterUser;
import br.com.userauth.domain.entities.user.User;
import br.com.userauth.infrastructure.http.dto.RegisterUserRequest;
import br.com.userauth.infrastructure.http.dto.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUser registerUser;
    private final DeactivateUser deactivateUser;

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
}
