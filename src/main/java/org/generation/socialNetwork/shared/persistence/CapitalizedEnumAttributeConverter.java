package org.generation.socialNetwork.shared.persistence;

import jakarta.persistence.AttributeConverter;
import java.util.Locale;

public abstract class CapitalizedEnumAttributeConverter<E extends Enum<E>> implements AttributeConverter<E, String> {

    private final Class<E> enumClass;

    protected CapitalizedEnumAttributeConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        if (attribute == null) {
            return null;
        }
        String lowercase = attribute.name().toLowerCase(Locale.ROOT);
        return Character.toUpperCase(lowercase.charAt(0)) + lowercase.substring(1);
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        return Enum.valueOf(enumClass, dbData.trim().toUpperCase(Locale.ROOT));
    }
}
