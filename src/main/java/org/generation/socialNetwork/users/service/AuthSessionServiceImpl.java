package org.generation.socialNetwork.users.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.users.dto.AuthSessionCreateRequestDTO;
import org.generation.socialNetwork.users.dto.AuthSessionResponseDTO;
import org.generation.socialNetwork.users.dto.AuthSessionUpdateRequestDTO;
import org.generation.socialNetwork.users.model.AuthSession;
import org.generation.socialNetwork.users.repository.AuthSessionRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthSessionServiceImpl implements AuthSessionService {

    private final AuthSessionRepository authSessionRepository;
    private final UserRepository userRepository;

    @Override
    public AuthSessionResponseDTO create(AuthSessionCreateRequestDTO dto) {
        validateUserExists(dto.getUserId(), "userId");
        AuthSession entity = AuthSessionMapper.toEntity(dto);
        return AuthSessionMapper.toResponseDTO(authSessionRepository.save(entity));
    }

    @Override
    public AuthSessionResponseDTO update(Long id, AuthSessionUpdateRequestDTO dto) {
        AuthSession entity = authSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AuthSession not found with id: " + id));
        validateUserExists(dto.getUserId(), "userId");
        AuthSessionMapper.updateEntity(entity, dto);
        return AuthSessionMapper.toResponseDTO(authSessionRepository.save(entity));
    }

    @Override
    public AuthSessionResponseDTO findById(Long id) {
        return authSessionRepository.findById(id)
                .map(AuthSessionMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("AuthSession not found with id: " + id));
    }

    @Override
    public List<AuthSessionResponseDTO> findAll() {
        return authSessionRepository.findAll().stream()
                .map(AuthSessionMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!authSessionRepository.existsById(id)) {
            throw new ResourceNotFoundException("AuthSession not found with id: " + id);
        }
        authSessionRepository.deleteById(id);
    }

    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
}