package org.generation.socialNetwork.contact.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class ContactMessageStatusConverter extends LowercaseEnumAttributeConverter<ContactMessageStatus> {

    public ContactMessageStatusConverter() {
        super(ContactMessageStatus.class);
    }
}
