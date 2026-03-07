package org.generation.socialNetwork.tours.repository;

import org.generation.socialNetwork.tours.model.TourDestinations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourDestinationsRepository extends JpaRepository<TourDestinations, Long> {
}
