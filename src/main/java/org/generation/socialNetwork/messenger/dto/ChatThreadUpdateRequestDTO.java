package org.generation.socialNetwork.messenger.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.messenger.model.*;

@Getter
@Setter
@NoArgsConstructor
public class ChatThreadUpdateRequestDTO {

    private Long tripId;
    private Long touristId;
    private Long guideId;
    private LocalDateTime lastMessageAt;
    private ChatThreadStatus status;
    private LocalDateTime createdAt;
}