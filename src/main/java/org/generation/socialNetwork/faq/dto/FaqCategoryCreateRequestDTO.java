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
public class FaqCategoryCreateRequestDTO {

    private String name;
    private FaqCategoryRoleScope roleScope;
    private Integer sortOrder;
}