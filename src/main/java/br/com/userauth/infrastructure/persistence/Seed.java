package br.com.userauth.infrastructure.persistence;

import br.com.userauth.application.ports.RoleRepository;
import br.com.userauth.domain.model.role.Role;
import br.com.userauth.domain.model.role.RoleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Seed implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public Seed(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Role role = new Role(UUID.randomUUID().toString(), RoleEnum.USER.toString());

        this.roleRepository.save(role);
    }
}
