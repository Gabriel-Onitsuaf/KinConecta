package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class GuideCalendarEventEventTypeConverter extends LowercaseEnumAttributeConverter<GuideCalendarEventEventType> {

    public GuideCalendarEventEventTypeConverter() {
        super(GuideCalendarEventEventType.class);
    }
}
