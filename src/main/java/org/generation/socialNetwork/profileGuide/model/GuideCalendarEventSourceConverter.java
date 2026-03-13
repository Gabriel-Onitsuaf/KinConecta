package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class GuideCalendarEventSourceConverter extends LowercaseEnumAttributeConverter<GuideCalendarEventSource> {

    public GuideCalendarEventSourceConverter() {
        super(GuideCalendarEventSource.class);
    }
}
