package br.com.userauth.application.ports.out;


import br.com.userauth.domain.entities.role.Role;

public interface RoleRepository {

    public void save(Role role);

    public Role findByName(String name);
}
