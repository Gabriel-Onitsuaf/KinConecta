package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.dto.TripStatusHistoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TripStatusHistoryUpdateRequestDTO;

import java.util.List;

public interface TripStatusHistoryService {

    TripStatusHistoryResponseDTO create(TripStatusHistoryCreateRequestDTO dto);

    TripStatusHistoryResponseDTO update(Long id, TripStatusHistoryUpdateRequestDTO dto);

    TripStatusHistoryResponseDTO findById(Long id);

    List<TripStatusHistoryResponseDTO> findAll();

    void delete(Long id);
}