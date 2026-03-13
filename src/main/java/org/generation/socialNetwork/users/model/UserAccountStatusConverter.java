package org.generation.socialNetwork.users.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class UserAccountStatusConverter implements AttributeConverter<UserAccountStatus, String> {

    @Override
    public String convertToDatabaseColumn(UserAccountStatus attribute) {
        return attribute == null ? null : attribute.name().toLowerCase();
    }

    @Override
    public UserAccountStatus convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        return UserAccountStatus.valueOf(dbData.trim().toUpperCase());
    }
}
