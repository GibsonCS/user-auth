package br.com.userauth.application.ports.out;

public interface PasswordEncoder {
    String encode(String password);
}
