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
public class TourResponseDTO {

    private Long tourId;
    private Long guideId;
    private Integer categoryId;
    private String title;
    private String description;
    private BigDecimal price;
    private String currency;
    private BigDecimal durationHours;
    private Integer maxGroupSize;
    private String meetingPoint;
    private TourStatus status;
    private String coverImageUrl;
    private String imageClass;
    private BigDecimal ratingAvg;
    private Integer bookingsCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}