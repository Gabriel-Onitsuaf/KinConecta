package org.generation.socialNetwork.auth;

public interface AuthService {
    AuthResponse login(AuthLoginRequest request);
    AuthResponse register(AuthRegisterRequest request);
    AuthResponse me(Long authenticatedUserId);
}
