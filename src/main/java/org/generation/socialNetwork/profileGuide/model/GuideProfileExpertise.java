package org.generation.socialNetwork.profileGuide.model;

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
import org.generation.socialNetwork.profileGuide.model.GuideExpertiseArea;
import org.generation.socialNetwork.profileGuide.model.GuideProfile;

@Entity
@Table(name = "guide_profile_expertise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@IdClass(GuideProfileExpertiseId.class)
public class GuideProfileExpertise {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "expertise_id")
    private Integer expertiseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private GuideProfile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expertise_id", referencedColumnName = "expertise_id", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private GuideExpertiseArea expertise;

}