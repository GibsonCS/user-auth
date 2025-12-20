package br.com.userauth.domain.exception;

public class UserNotIsActiveException extends RuntimeException {
    public UserNotIsActiveException(String message) {
        super(message);
    }
}
