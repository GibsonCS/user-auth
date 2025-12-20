package br.com.userauth.infrastructure.persistence.role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleJpaRepository extends JpaRepository<RoleEntity, Integer> {

    public RoleEntity findByRoleName(String roleName);
}
