package org.generation.socialNetwork.notifications.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.notifications.model.*;

@Getter
@Setter
@NoArgsConstructor
public class NotificationUpdateRequestDTO {

    private Long userId;
    private String type;
    private String title;
    private String body;
    private String relatedEntityType;
    private Long relatedEntityId;
    private Boolean isRead;
    private LocalDateTime createdAt;
    private LocalDateTime readAt;
}