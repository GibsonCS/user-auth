package br.com.userauth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleJpaRepository extends JpaRepository<RoleEntity, String> {

    public RoleEntity findByRoleName(String roleName);
}
