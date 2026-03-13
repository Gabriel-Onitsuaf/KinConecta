package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class GuideCalendarEventStatusConverter extends LowercaseEnumAttributeConverter<GuideCalendarEventStatus> {

    public GuideCalendarEventStatusConverter() {
        super(GuideCalendarEventStatus.class);
    }
}
