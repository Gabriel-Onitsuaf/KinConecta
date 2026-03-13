package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TripBookingCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripBookingResponseDTO;
import org.generation.socialNetwork.tours.dto.TripBookingUpdateRequestDTO;

import java.util.List;

public interface TripBookingService {

    TripBookingResponseDTO create(TripBookingCreateRequestDTO dto);

    TripBookingResponseDTO update(Long id, TripBookingUpdateRequestDTO dto);

    TripBookingResponseDTO findById(Long id);

    List<TripBookingResponseDTO> findAll();

    void delete(Long id);
}