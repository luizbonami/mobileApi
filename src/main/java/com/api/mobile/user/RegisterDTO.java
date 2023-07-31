package com.api.mobile.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
