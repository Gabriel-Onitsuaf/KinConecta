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
import org.generation.socialNetwork.profileTourist.model.Interest;
import org.generation.socialNetwork.profileTourist.model.TouristProfile;

@Entity
@Table(name = "tourist_profile_interests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@IdClass(TouristProfileInterestId.class)
public class TouristProfileInterest {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "interest_id")
    private Integer interestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TouristProfile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interest_id", referencedColumnName = "interest_id", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Interest interest;

}