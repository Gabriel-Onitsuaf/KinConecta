package org.generation.socialNetwork.profileTourist.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.profileTourist.model.*;

@Getter
@Setter
@NoArgsConstructor
public class TouristProfileLanguageCreateRequestDTO {

    private Long userId;
    private String languageCode;
}