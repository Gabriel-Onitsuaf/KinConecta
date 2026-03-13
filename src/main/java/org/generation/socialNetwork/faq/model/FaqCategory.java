package org.generation.socialNetwork.faq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "faq_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FaqCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_category_id")
    private Integer faqCategoryId;

    @Column(name = "name")
    private String name;

    @Convert(converter = FaqCategoryRoleScopeConverter.class)
    @Column(name = "role_scope")
    private FaqCategoryRoleScope roleScope;

    @Column(name = "sort_order")
    private Integer sortOrder;


}
