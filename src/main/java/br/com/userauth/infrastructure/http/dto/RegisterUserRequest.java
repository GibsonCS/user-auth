package br.com.userauth.infrastructure.http.dto;

public record RegisterUserRequest(String login, String email, String password) {
}
