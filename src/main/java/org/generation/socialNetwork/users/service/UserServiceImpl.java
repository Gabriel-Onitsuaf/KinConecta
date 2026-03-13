package org.generation.socialNetwork.users.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.users.dto.UserCreateRequestDTO;
import org.generation.socialNetwork.users.dto.UserResponseDTO;
import org.generation.socialNetwork.users.dto.UserUpdateRequestDTO;
import org.generation.socialNetwork.users.model.User;
import org.generation.socialNetwork.users.repository.LanguageRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO create(UserCreateRequestDTO dto) {
        validateLanguageExists(dto.getPreferredLanguageCode(), "preferredLanguageCode");
        User entity = UserMapper.toEntity(dto);
        normalizeAndSecurePassword(entity);
        LocalDateTime now = LocalDateTime.now();
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(now);
        }
        entity.setUpdatedAt(now);
        return UserMapper.toResponseDTO(userRepository.save(entity));
    }

    @Override
    public UserResponseDTO update(Long id, UserUpdateRequestDTO dto) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        validateLanguageExists(dto.getPreferredLanguageCode(), "preferredLanguageCode");
        UserMapper.updateEntity(entity, dto);
        normalizeAndSecurePassword(entity);
        entity.setUpdatedAt(LocalDateTime.now());
        return UserMapper.toResponseDTO(userRepository.save(entity));
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    private void validateLanguageExists(String id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!languageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Language not found for " + fieldName + ": " + id);
        }
    }

    private void normalizeAndSecurePassword(User entity) {
        String passwordHash = entity.getPasswordHash();
        if (passwordHash == null || passwordHash.isBlank()) {
            return;
        }
        if (!passwordHash.startsWith("$2a$") && !passwordHash.startsWith("$2b$") && !passwordHash.startsWith("$2y$")) {
            entity.setPasswordHash(passwordEncoder.encode(passwordHash));
        }
        if (entity.getEmail() != null) {
            entity.setEmail(entity.getEmail().trim().toLowerCase());
        }
    }
}
