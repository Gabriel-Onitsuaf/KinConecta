package org.generation.socialNetwork.help.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class SupportTicketCategoryConverter extends LowercaseEnumAttributeConverter<SupportTicketCategory> {

    public SupportTicketCategoryConverter() {
        super(SupportTicketCategory.class);
    }
}
