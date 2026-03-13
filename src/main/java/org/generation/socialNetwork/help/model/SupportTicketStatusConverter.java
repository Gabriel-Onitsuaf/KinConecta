package org.generation.socialNetwork.help.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class SupportTicketStatusConverter extends LowercaseEnumAttributeConverter<SupportTicketStatus> {

    public SupportTicketStatusConverter() {
        super(SupportTicketStatus.class);
    }
}
