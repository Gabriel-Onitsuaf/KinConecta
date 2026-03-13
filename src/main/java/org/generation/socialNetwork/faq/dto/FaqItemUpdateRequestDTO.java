package org.generation.socialNetwork.faq.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.faq.model.*;

@Getter
@Setter
@NoArgsConstructor
public class FaqItemUpdateRequestDTO {

    private Integer faqCategoryId;
    private String question;
    private String answer;
    private Boolean isActive;
    private Integer sortOrder;
}