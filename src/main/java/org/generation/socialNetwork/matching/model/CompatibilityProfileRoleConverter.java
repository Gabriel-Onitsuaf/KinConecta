package org.generation.socialNetwork.matching.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class CompatibilityProfileRoleConverter extends LowercaseEnumAttributeConverter<CompatibilityProfileRole> {

    public CompatibilityProfileRoleConverter() {
        super(CompatibilityProfileRole.class);
    }
}
