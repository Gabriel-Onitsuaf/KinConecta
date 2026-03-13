package org.generation.socialNetwork.messenger.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class ChatThreadStatusConverter extends LowercaseEnumAttributeConverter<ChatThreadStatus> {

    public ChatThreadStatusConverter() {
        super(ChatThreadStatus.class);
    }
}
