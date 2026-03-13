package org.generation.socialNetwork;

import org.generation.socialNetwork.profileGuide.repository.GuideProfileRepository;
import org.generation.socialNetwork.profileTourist.repository.TouristProfileRepository;
import org.generation.socialNetwork.tours.model.TourCategory;
import org.generation.socialNetwork.tours.repository.TourCategoryRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.generation.socialNetwork.users.model.AuthSession;
import org.generation.socialNetwork.users.model.User;
import org.generation.socialNetwork.users.model.UserAccountStatus;
import org.generation.socialNetwork.users.model.UserRole;
import org.generation.socialNetwork.users.repository.AuthSessionRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AuthSecurityIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthSessionRepository authSessionRepository;

    @Autowired
    private TouristProfileRepository touristProfileRepository;

    @Autowired
    private GuideProfileRepository guideProfileRepository;

    @Autowired
    private TourCategoryRepository tourCategoryRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        authSessionRepository.deleteAll();
        guideProfileRepository.deleteAll();
        touristProfileRepository.deleteAll();
        tourRepository.deleteAll();
        tourCategoryRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void registerCreatesHashedPasswordAndProfile() throws Exception {
        String payload = objectMapper.writeValueAsString(Map.of(
                "role", "TOURIST",
                "fullName", "QA Tourist",
                "dateOfBirth", "1995-02-10",
                "email", "qa-tourist@example.com",
                "password", "Secreta123",
                "countryCode", "+52",
                "phoneNumber", "5512345678"
        ));

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.token").isString())
                .andExpect(jsonPath("$.user.email").value("qa-tourist@example.com"))
                .andExpect(jsonPath("$.user.passwordHash").doesNotExist());

        User createdUser = userRepository.findByEmailIgnoreCase("qa-tourist@example.com").orElseThrow();
        assertThat(createdUser.getPasswordHash()).startsWith("$2");
        assertThat(passwordEncoder.matches("Secreta123", createdUser.getPasswordHash())).isTrue();
        assertThat(touristProfileRepository.findById(createdUser.getUserId())).isPresent();
    }

    @Test
    void privateEndpointsRequireAuthentication() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isUnauthorized());

        mockMvc.perform(get("/api/auth/me"))
                .andExpect(status().isUnauthorized());

        mockMvc.perform(get("/api/auth_sessions"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void authMeReturnsAuthenticatedUser() throws Exception {
        User user = createUser("auth-me-user@example.com", passwordEncoder.encode("Secreta123"));
        String token = loginAndGetToken(user.getEmail(), "Secreta123");

        mockMvc.perform(get("/api/auth/me")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.userId").value(user.getUserId()))
                .andExpect(jsonPath("$.user.fullName").value("Integration User"))
                .andExpect(jsonPath("$.user.passwordHash").doesNotExist());
    }

    @Test
    void usersResponseOmitsPasswordHash() throws Exception {
        User user = createUser("secure-user@example.com", passwordEncoder.encode("Secreta123"));
        String token = loginAndGetToken(user.getEmail(), "Secreta123");

        mockMvc.perform(get("/api/users")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("secure-user@example.com"))
                .andExpect(jsonPath("$[0].passwordHash").doesNotExist());
    }

    @Test
    void authSessionsResponseOmitsTokenHash() throws Exception {
        User user = createUser("session-user@example.com", passwordEncoder.encode("Secreta123"));
        AuthSession session = new AuthSession();
        session.setUserId(user.getUserId());
        session.setTokenHash("super-secret-token-hash");
        session.setExpiresAt(LocalDateTime.now().plusHours(1));
        session.setCreatedAt(LocalDateTime.now());
        session.setIp("127.0.0.1");
        session.setUserAgent("MockMvc");
        authSessionRepository.save(session);

        String token = loginAndGetToken(user.getEmail(), "Secreta123");

        mockMvc.perform(get("/api/auth_sessions")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(user.getUserId()))
                .andExpect(jsonPath("$[0].tokenHash").doesNotExist());
    }

    @Test
    void loginMigratesLegacyPlainTextPasswords() throws Exception {
        User user = createUser("legacy-user@example.com", "TextoPlano123");

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Map.of(
                                "email", "legacy-user@example.com",
                                "password", "TextoPlano123"
                        ))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").isString());

        User updatedUser = userRepository.findById(user.getUserId()).orElseThrow();
        assertThat(updatedUser.getPasswordHash()).startsWith("$2");
        assertThat(passwordEncoder.matches("TextoPlano123", updatedUser.getPasswordHash())).isTrue();
    }

    @Test
    void invalidRouteReturnsNotFound() throws Exception {
        User user = createUser("not-found-user@example.com", passwordEncoder.encode("Secreta123"));
        String token = loginAndGetToken(user.getEmail(), "Secreta123");

        mockMvc.perform(get("/api/does-not-exist")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404));
    }

    @Test
    void createTourPersistsDefaultCountersAndCanBeListed() throws Exception {
        User guide = createGuideUser("tour-guide@example.com", passwordEncoder.encode("Secreta123"));
        TourCategory category = new TourCategory();
        category.setName("Gastronomia local");
        TourCategory savedCategory = tourCategoryRepository.save(category);
        String token = loginAndGetToken(guide.getEmail(), "Secreta123");

        mockMvc.perform(post("/api/tours")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Map.of(
                                "guideId", guide.getUserId(),
                                "categoryId", savedCategory.getCategoryId(),
                                "title", "Tour backend QA",
                                "description", "Descripcion suficientemente larga para validar el guardado del tour",
                                "price", 950,
                                "currency", "MXN",
                                "durationHours", 4,
                                "maxGroupSize", 8,
                                "meetingPoint", "Centro",
                                "status", "ACTIVE"
                        ))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Tour backend QA"))
                .andExpect(jsonPath("$.bookingsCount").value(0))
                .andExpect(jsonPath("$.ratingAvg").value(0));

        mockMvc.perform(get("/api/tours")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Tour backend QA"));
    }

    private User createUser(String email, String passwordHash) {
        User user = new User();
        user.setRole(UserRole.TOURIST);
        user.setFullName("Integration User");
        user.setDateOfBirth(LocalDate.of(1990, 1, 1));
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        user.setCountryCode("+52");
        user.setPhoneNumber("5512345678");
        user.setPhoneE164("+525512345678");
        user.setAccountStatus(UserAccountStatus.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    private User createGuideUser(String email, String passwordHash) {
        User user = createUser(email, passwordHash);
        user.setRole(UserRole.GUIDE);
        return userRepository.save(user);
    }

    private String loginAndGetToken(String email, String password) throws Exception {
        String response = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Map.of(
                                "email", email,
                                "password", password
                        ))))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readTree(response).get("token").asText();
    }
}
