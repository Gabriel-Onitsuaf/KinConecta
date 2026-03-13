package org.generation.socialNetwork.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.users.model.UserRole;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AuthRegisterRequest {

    @NotNull
    private UserRole role;

    @NotBlank
    private String fullName;

    @NotNull
    private LocalDate dateOfBirth;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    private String countryCode;

    @NotBlank
    private String phoneNumber;
}
