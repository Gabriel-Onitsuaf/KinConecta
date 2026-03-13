package org.generation.socialNetwork.profileGuide.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.profileGuide.model.*;

@Getter
@Setter
@NoArgsConstructor
public class WithdrawalRequestCreateRequestDTO {

    private Long guideId;
    private BigDecimal requestedAmount;
    private WithdrawalRequestStatus status;
    private String bankReference;
    private String notes;
    private LocalDateTime requestedAt;
    private LocalDateTime processedAt;
    private Long processedByUserId;
}