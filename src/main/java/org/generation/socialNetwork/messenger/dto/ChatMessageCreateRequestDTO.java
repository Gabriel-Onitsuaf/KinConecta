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
public class ChatMessageCreateRequestDTO {

    private Long threadId;
    private Long senderUserId;
    private String body;
    private ChatMessageMessageType messageType;
    private LocalDateTime sentAt;
    private LocalDateTime readAt;
}