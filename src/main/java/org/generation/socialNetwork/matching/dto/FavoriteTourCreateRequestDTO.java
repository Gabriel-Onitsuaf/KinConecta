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
public class FavoriteTourCreateRequestDTO {

    private Long touristId;
    private Long tourId;
    private LocalDateTime createdAt;
}