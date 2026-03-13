package org.generation.socialNetwork.profileTourist.repository;

import org.generation.socialNetwork.profileTourist.model.TouristProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristProfileRepository extends JpaRepository<TouristProfile, Long> {
}