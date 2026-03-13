package org.generation.socialNetwork.messenger.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class ChatMessageMessageTypeConverter extends LowercaseEnumAttributeConverter<ChatMessageMessageType> {

    public ChatMessageMessageTypeConverter() {
        super(ChatMessageMessageType.class);
    }
}
