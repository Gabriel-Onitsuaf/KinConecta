package org.generation.socialNetwork.contact.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.contact.model.*;

@Getter
@Setter
@NoArgsConstructor
public class ContactMessageCreateRequestDTO {

    private String name;
    private String email;
    private String subject;
    private String message;
    private String sourcePage;
    private ContactMessageStatus status;
    private LocalDateTime createdAt;
}