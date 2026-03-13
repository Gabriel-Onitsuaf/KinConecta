package org.generation.socialNetwork.tours.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class TourStatusConverter implements AttributeConverter<TourStatus, String> {

    @Override
    public String convertToDatabaseColumn(TourStatus attribute) {
        return attribute == null ? null : attribute.name().toLowerCase();
    }

    @Override
    public TourStatus convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        return TourStatus.valueOf(dbData.trim().toUpperCase());
    }
}
