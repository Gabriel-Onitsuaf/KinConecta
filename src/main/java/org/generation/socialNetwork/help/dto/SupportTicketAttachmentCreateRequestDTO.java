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
public class SupportTicketAttachmentCreateRequestDTO {

    private Long ticketId;
    private String fileUrl;
    private String fileName;
    private String mimeType;
    private Long fileSizeBytes;
    private LocalDateTime uploadedAt;
}