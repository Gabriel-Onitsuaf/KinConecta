package org.generation.socialNetwork.messenger.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChatMessageResponseDTO {

    private Long messageId;

    private String body;

    private LocalDateTime sentAt;

}