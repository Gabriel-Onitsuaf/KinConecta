package org.generation.socialNetwork.profileTourist.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.CapitalizedEnumAttributeConverter;

@Converter(autoApply = false)
public class TouristProfileActivityLevelConverter extends CapitalizedEnumAttributeConverter<TouristProfileActivityLevel> {

    public TouristProfileActivityLevelConverter() {
        super(TouristProfileActivityLevel.class);
    }
}
