package org.generation.socialNetwork.tours.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.DestinationCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.DestinationResponseDTO;
import org.generation.socialNetwork.tours.dto.DestinationUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.Destination;
import org.generation.socialNetwork.tours.repository.DestinationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;

    @Override
    public DestinationResponseDTO create(DestinationCreateRequestDTO dto) {

        Destination entity = DestinationMapper.toEntity(dto);
        return DestinationMapper.toResponseDTO(destinationRepository.save(entity));
    }

    @Override
    public DestinationResponseDTO update(Long id, DestinationUpdateRequestDTO dto) {
        Destination entity = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + id));

        DestinationMapper.updateEntity(entity, dto);
        return DestinationMapper.toResponseDTO(destinationRepository.save(entity));
    }

    @Override
    public DestinationResponseDTO findById(Long id) {
        return destinationRepository.findById(id)
                .map(DestinationMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + id));
    }

    @Override
    public List<DestinationResponseDTO> findAll() {
        return destinationRepository.findAll().stream()
                .map(DestinationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Destination not found with id: " + id);
        }
        destinationRepository.deleteById(id);
    }


}