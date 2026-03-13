package org.generation.socialNetwork.tours.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.tours.model.*;

@Getter
@Setter
@NoArgsConstructor
public class TourCategoryCreateRequestDTO {

    private String name;
}