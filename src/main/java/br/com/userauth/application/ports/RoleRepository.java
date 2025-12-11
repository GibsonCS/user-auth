package br.com.userauth.application.ports;


import br.com.userauth.domain.model.role.Role;

public interface RoleRepository {

    public void save(Role role);

    public Role findByName(String name);
}
