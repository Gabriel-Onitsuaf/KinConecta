package org.generation.socialNetwork.shared.persistence;

import jakarta.persistence.AttributeConverter;

public abstract class LowercaseEnumAttributeConverter<E extends Enum<E>> implements AttributeConverter<E, String> {

    private final Class<E> enumClass;

    protected LowercaseEnumAttributeConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute == null ? null : attribute.name().toLowerCase();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        return Enum.valueOf(enumClass, normalizeEnumToken(dbData));
    }

    private String normalizeEnumToken(String rawValue) {
        return rawValue.trim()
                .replace('-', '_')
                .replace(' ', '_')
                .toUpperCase();
    }
}
