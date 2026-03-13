package org.generation.socialNetwork.auth;

import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.BadRequestException;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileGuide.model.GuideProfile;
import org.generation.socialNetwork.profileGuide.repository.GuideProfileRepository;
import org.generation.socialNetwork.profileTourist.model.TouristProfile;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileRepository;
import org.generation.socialNetwork.users.dto.UserResponseDTO;
import org.generation.socialNetwork.users.model.User;
import org.generation.socialNetwork.users.model.UserAccountStatus;
import org.generation.socialNetwork.users.model.UserRole;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.generation.socialNetwork.users.service.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final GuideProfileRepository guideProfileRepository;
    private final TouristProfileRepository touristProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    @Transactional
    public AuthResponse login(AuthLoginRequest request) {
        User user = userRepository.findByEmailIgnoreCase(normalizeEmail(request.getEmail()))
                .orElseThrow(() -> new BadRequestException("Credenciales invalidas"));

        if (!passwordMatches(request.getPassword(), user.getPasswordHash())) {
            throw new BadRequestException("Credenciales invalidas");
        }

        if (isLegacyPlainTextPassword(user.getPasswordHash())) {
            user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        }
        user.setLastLoginAt(LocalDateTime.now());
        userRepository.save(user);
        return buildAuthResponse(user);
    }

    @Override
    @Transactional
    public AuthResponse register(AuthRegisterRequest request) {
        String email = normalizeEmail(request.getEmail());
        if (userRepository.findByEmailIgnoreCase(email).isPresent()) {
            throw new BadRequestException("Ya existe una cuenta registrada con ese correo");
        }

        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setRole(request.getRole());
        user.setFullName(request.getFullName().trim());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setCountryCode(request.getCountryCode().trim());
        user.setPhoneNumber(request.getPhoneNumber().replaceAll("\\D", ""));
        user.setPhoneE164(user.getCountryCode() + user.getPhoneNumber());
        user.setAccountStatus(UserAccountStatus.ACTIVE);
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        User savedUser = userRepository.save(user);
        createDefaultProfile(savedUser);
        return buildAuthResponse(savedUser);
    }

    @Override
    public AuthResponse me(Long authenticatedUserId) {
        User user = userRepository.findById(authenticatedUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + authenticatedUserId));
        return buildAuthResponse(user);
    }

    private AuthResponse buildAuthResponse(User user) {
        UserResponseDTO userDto = UserMapper.toResponseDTO(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token, jwtService.getExpirationMs(), userDto);
    }

    private void createDefaultProfile(User user) {
        if (user.getRole() == UserRole.GUIDE && !guideProfileRepository.existsById(user.getUserId())) {
            GuideProfile profile = new GuideProfile();
            profile.setUserId(user.getUserId());
            profile.setSummary("");
            profile.setCurrency("MXN");
            profile.setReviewsCount(0);
            profile.setUpdatedAt(LocalDateTime.now());
            guideProfileRepository.save(profile);
            return;
        }

        if (user.getRole() == UserRole.TOURIST && !touristProfileRepository.existsById(user.getUserId())) {
            TouristProfile profile = new TouristProfile();
            profile.setUserId(user.getUserId());
            profile.setLocation("");
            profile.setBio("");
            profile.setUpdatedAt(LocalDateTime.now());
            touristProfileRepository.save(profile);
        }
    }

    private boolean passwordMatches(String rawPassword, String storedPassword) {
        if (storedPassword == null || storedPassword.isBlank()) {
            return false;
        }
        if (isLegacyPlainTextPassword(storedPassword)) {
            return storedPassword.equals(rawPassword);
        }
        return passwordEncoder.matches(rawPassword, storedPassword);
    }

    private boolean isLegacyPlainTextPassword(String password) {
        return password != null && !password.startsWith("$2a$") && !password.startsWith("$2b$") && !password.startsWith("$2y$");
    }

    private String normalizeEmail(String email) {
        return email == null ? "" : email.trim().toLowerCase();
    }
}
