package br.com.userauth.infrastructure.persistence.role;

import br.com.userauth.application.ports.out.RoleRepository;
import br.com.userauth.domain.entities.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    public final RoleJpaRepository jpa;

    @Override
    public void save(Role role) {

        RoleEntity entity = RoleMapper.toEntity(role);

        jpa.save(entity);
    }

    @Override
    public Role findByName(String name) {

        RoleEntity entity = jpa.findByRoleName(name);

        return RoleMapper.toDomain(entity);
    }
}
