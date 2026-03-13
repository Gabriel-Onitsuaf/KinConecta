package org.generation.socialNetwork.matching.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.matching.model.*;

@Getter
@Setter
@NoArgsConstructor
public class CompatibilityProfileResponseDTO {

    private Long compatibilityProfileId;
    private Long userId;
    private CompatibilityProfileRole role;
    private String name;
    private String imgUrl;
    private String description;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneCountryCode;
    private String phoneNumber;
    private String phoneE164;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}