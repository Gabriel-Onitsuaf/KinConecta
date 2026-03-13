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
public class TripBookingResponseDTO {

    private Long tripId;
    private Long tourId;
    private Long touristId;
    private Long guideId;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private TripBookingStatus status;
    private String cancelReason;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}