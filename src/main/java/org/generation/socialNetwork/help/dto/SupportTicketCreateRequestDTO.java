package org.generation.socialNetwork.help.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.help.model.*;

@Getter
@Setter
@NoArgsConstructor
public class SupportTicketCreateRequestDTO {

    private Long userId;
    private SupportTicketRoleContext roleContext;
    private String fullName;
    private String email;
    private String subject;
    private SupportTicketCategory category;
    private String message;
    private SupportTicketStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}