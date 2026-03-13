package org.generation.socialNetwork.users.service;

import org.generation.socialNetwork.users.dto.UserCreateRequestDTO;
import org.generation.socialNetwork.users.dto.UserResponseDTO;
import org.generation.socialNetwork.users.dto.UserUpdateRequestDTO;
import org.generation.socialNetwork.users.model.User;

public class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserCreateRequestDTO dto) {
        User entity = new User();
        entity.setRole(dto.getRole());
        entity.setFullName(dto.getFullName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setEmail(dto.getEmail());
        entity.setPasswordHash(dto.getPasswordHash());
        entity.setCountryCode(dto.getCountryCode());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPhoneE164(dto.getPhoneE164());
        entity.setPreferredLanguageCode(dto.getPreferredLanguageCode());
        entity.setAccountStatus(dto.getAccountStatus());
        entity.setEmailVerifiedAt(dto.getEmailVerifiedAt());
        entity.setLastLoginAt(dto.getLastLoginAt());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static void updateEntity(User entity, UserUpdateRequestDTO dto) {
        entity.setRole(dto.getRole());
        entity.setFullName(dto.getFullName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setEmail(dto.getEmail());
        entity.setPasswordHash(dto.getPasswordHash());
        entity.setCountryCode(dto.getCountryCode());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPhoneE164(dto.getPhoneE164());
        entity.setPreferredLanguageCode(dto.getPreferredLanguageCode());
        entity.setAccountStatus(dto.getAccountStatus());
        entity.setEmailVerifiedAt(dto.getEmailVerifiedAt());
        entity.setLastLoginAt(dto.getLastLoginAt());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public static UserResponseDTO toResponseDTO(User entity) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(entity.getUserId());
        dto.setRole(entity.getRole());
        dto.setFullName(entity.getFullName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setEmail(entity.getEmail());
        dto.setCountryCode(entity.getCountryCode());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setPhoneE164(entity.getPhoneE164());
        dto.setPreferredLanguageCode(entity.getPreferredLanguageCode());
        dto.setAccountStatus(entity.getAccountStatus());
        dto.setEmailVerifiedAt(entity.getEmailVerifiedAt());
        dto.setLastLoginAt(entity.getLastLoginAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
