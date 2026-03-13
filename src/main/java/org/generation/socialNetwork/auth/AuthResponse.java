package org.generation.socialNetwork.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.generation.socialNetwork.users.dto.UserResponseDTO;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private long expiresInMs;
    private UserResponseDTO user;
}
