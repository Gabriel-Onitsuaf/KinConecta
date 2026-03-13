package org.generation.socialNetwork.users.service;

import org.generation.socialNetwork.users.dto.AuthSessionCreateRequestDTO;
import org.generation.socialNetwork.users.dto.AuthSessionResponseDTO;
import org.generation.socialNetwork.users.dto.AuthSessionUpdateRequestDTO;
import org.generation.socialNetwork.users.model.AuthSession;

public class AuthSessionMapper {

    private AuthSessionMapper() {
    }

    public static AuthSession toEntity(AuthSessionCreateRequestDTO dto) {
        AuthSession entity = new AuthSession();
        entity.setUserId(dto.getUserId());
        entity.setTokenHash(dto.getTokenHash());
        entity.setExpiresAt(dto.getExpiresAt());
        entity.setRevokedAt(dto.getRevokedAt());
        entity.setIp(dto.getIp());
        entity.setUserAgent(dto.getUserAgent());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public static void updateEntity(AuthSession entity, AuthSessionUpdateRequestDTO dto) {
        entity.setUserId(dto.getUserId());
        entity.setTokenHash(dto.getTokenHash());
        entity.setExpiresAt(dto.getExpiresAt());
        entity.setRevokedAt(dto.getRevokedAt());
        entity.setIp(dto.getIp());
        entity.setUserAgent(dto.getUserAgent());
        entity.setCreatedAt(dto.getCreatedAt());
    }

    public static AuthSessionResponseDTO toResponseDTO(AuthSession entity) {
        AuthSessionResponseDTO dto = new AuthSessionResponseDTO();
        dto.setSessionId(entity.getSessionId());
        dto.setUserId(entity.getUserId());
        dto.setExpiresAt(entity.getExpiresAt());
        dto.setRevokedAt(entity.getRevokedAt());
        dto.setIp(entity.getIp());
        dto.setUserAgent(entity.getUserAgent());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
