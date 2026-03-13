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
public class IncomeTransactionUpdateRequestDTO {

    private Long guideId;
    private Long tripId;
    private Long tourId;
    private IncomeTransactionTxnType txnType;
    private BigDecimal amount;
    private IncomeTransactionSign sign;
    private IncomeTransactionStatus status;
    private String description;
    private LocalDateTime occurredAt;
    private LocalDateTime createdAt;
}