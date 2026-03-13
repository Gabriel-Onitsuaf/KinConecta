package org.generation.socialNetwork.help.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class SupportTicketRoleContextConverter extends LowercaseEnumAttributeConverter<SupportTicketRoleContext> {

    public SupportTicketRoleContextConverter() {
        super(SupportTicketRoleContext.class);
    }
}
