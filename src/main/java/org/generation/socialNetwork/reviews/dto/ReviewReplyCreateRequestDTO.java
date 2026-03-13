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
public class ReviewReplyCreateRequestDTO {

    private Long reviewId;
    private Long guideId;
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}