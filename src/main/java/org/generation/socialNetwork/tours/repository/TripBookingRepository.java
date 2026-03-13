package org.generation.socialNetwork.tours.repository;

import org.generation.socialNetwork.tours.model.TripBooking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepository extends JpaRepository<TripBooking, Long> {
}