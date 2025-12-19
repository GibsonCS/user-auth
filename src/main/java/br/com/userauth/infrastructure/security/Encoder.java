package br.com.userauth.infrastructure.security;

import br.com.userauth.application.ports.out.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder implements PasswordEncoder {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Encoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
