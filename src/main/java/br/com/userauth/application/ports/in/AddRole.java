package br.com.userauth.application.ports.in;

public interface AddRole {
    public void execute(String userId, Integer roleId);
}
