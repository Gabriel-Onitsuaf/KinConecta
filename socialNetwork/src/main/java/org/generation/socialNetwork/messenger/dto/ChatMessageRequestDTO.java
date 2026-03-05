package org.generation.socialNetwork.messenger.dto;

import lombok.Data;

@Data
public class ChatMessageRequestDTO {

    private Long threadId;

    private Long senderUserId;

    private String body;

}