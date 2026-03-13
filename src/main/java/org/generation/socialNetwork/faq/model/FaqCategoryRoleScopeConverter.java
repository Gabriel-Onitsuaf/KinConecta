package org.generation.socialNetwork.faq.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class FaqCategoryRoleScopeConverter extends LowercaseEnumAttributeConverter<FaqCategoryRoleScope> {

    public FaqCategoryRoleScopeConverter() {
        super(FaqCategoryRoleScope.class);
    }
}
