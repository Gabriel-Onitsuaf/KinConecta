package org.generation.socialNetwork.users.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.users.model.*;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateRequestDTO {

    private UserRole role;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String passwordHash;
    private String countryCode;
    private String phoneNumber;
    private String phoneE164;
    private String preferredLanguageCode;
    private UserAccountStatus accountStatus;
    private LocalDateTime emailVerifiedAt;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}