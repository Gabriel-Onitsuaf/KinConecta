package org.generation.socialNetwork.profileTourist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.generation.socialNetwork.users.model.User;

@Entity
@Table(name = "tourist_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TouristProfile {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "location")
    private String location;

    @Column(name = "bio")
    private String bio;

    @Column(name = "member_since")
    private LocalDate memberSince;

    @Column(name = "badge")
    private String badge;

    @Column(name = "travel_style")
    private String travelStyle;

    @Column(name = "trip_type")
    private String tripType;

    @Column(name = "pace_and_company")
    private String paceAndCompany;

    @Convert(converter = TouristProfileActivityLevelConverter.class)
    @Column(name = "activity_level")
    private TouristProfileActivityLevel activityLevel;

    @Column(name = "group_preference")
    private String groupPreference;

    @Column(name = "dietary_preferences")
    private String dietaryPreferences;

    @Convert(converter = TouristProfilePlanningLevelConverter.class)
    @Column(name = "planning_level")
    private TouristProfilePlanningLevel planningLevel;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "transport")
    private String transport;

    @Column(name = "photo_preference")
    private String photoPreference;

    @Column(name = "accessibility")
    private String accessibility;

    @Column(name = "additional_notes")
    private String additionalNotes;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

}
