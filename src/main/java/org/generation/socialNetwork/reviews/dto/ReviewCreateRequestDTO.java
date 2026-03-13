package org.generation.socialNetwork.reviews.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.reviews.model.*;

@Getter
@Setter
@NoArgsConstructor
public class ReviewCreateRequestDTO {

    private Long tripId;
    private Long tourId;
    private Long guideId;
    private Long touristId;
    private Integer rating;
    private String comment;
    private Integer likesCount;
    private Integer repliesCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}