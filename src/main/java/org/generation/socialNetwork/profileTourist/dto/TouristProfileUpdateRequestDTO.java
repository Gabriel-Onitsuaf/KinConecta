package org.generation.socialNetwork.profileTourist.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.socialNetwork.profileTourist.model.*;

@Getter
@Setter
@NoArgsConstructor
public class TouristProfileUpdateRequestDTO {

    private String location;
    private String bio;
    private LocalDate memberSince;
    private String badge;
    private String travelStyle;
    private String tripType;
    private String paceAndCompany;
    private TouristProfileActivityLevel activityLevel;
    private String groupPreference;
    private String dietaryPreferences;
    private TouristProfilePlanningLevel planningLevel;
    private String amenities;
    private String transport;
    private String photoPreference;
    private String accessibility;
    private String additionalNotes;
    private String avatarUrl;
    private String coverUrl;
    private LocalDateTime updatedAt;
}