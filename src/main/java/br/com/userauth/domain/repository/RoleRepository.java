package br.com.userauth.domain.repository;


import br.com.userauth.domain.model.role.Role;

public interface RoleRepository {

    public void save(Role role);

    public Role findByName(String name);
}
