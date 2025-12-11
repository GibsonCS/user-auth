package br.com.userauth.application.ports;

public interface PasswordEncoder {
    String encode(String password);
}
