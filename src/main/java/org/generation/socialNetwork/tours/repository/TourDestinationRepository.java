package org.generation.socialNetwork.tours.repository;

import org.generation.socialNetwork.tours.model.TourDestination;
import org.generation.socialNetwork.tours.model.TourDestinationId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TourDestinationRepository extends JpaRepository<TourDestination, TourDestinationId> {
}