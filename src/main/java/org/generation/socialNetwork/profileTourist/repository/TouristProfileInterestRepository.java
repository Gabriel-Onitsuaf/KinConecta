package org.generation.socialNetwork.profileTourist.repository;

import org.generation.socialNetwork.profileTourist.model.TouristProfileInterest;
import org.generation.socialNetwork.profileTourist.model.TouristProfileInterestId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristProfileInterestRepository extends JpaRepository<TouristProfileInterest, TouristProfileInterestId> {
}