package org.generation.socialNetwork.profileTourist.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.CapitalizedEnumAttributeConverter;

@Converter(autoApply = false)
public class TouristProfilePlanningLevelConverter extends CapitalizedEnumAttributeConverter<TouristProfilePlanningLevel> {

    public TouristProfilePlanningLevelConverter() {
        super(TouristProfilePlanningLevel.class);
    }
}
