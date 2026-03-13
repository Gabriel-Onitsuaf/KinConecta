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
public class AuthSessionCreateRequestDTO {

    private Long userId;
    private String tokenHash;
    private LocalDateTime expiresAt;
    private LocalDateTime revokedAt;
    private String ip;
    private String userAgent;
    private LocalDateTime createdAt;
}