package org.generation.socialNetwork.profileTourist.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileTourist.dto.InterestCreateRequestDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestResponseDTO;
import org.generation.socialNetwork.profileTourist.dto.InterestUpdateRequestDTO;
import org.generation.socialNetwork.profileTourist.model.Interest;
import org.generation.socialNetwork.profileTourist.repository.InterestRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestServiceImpl implements InterestService {

    private final InterestRepository interestRepository;

    @Override
    public InterestResponseDTO create(InterestCreateRequestDTO dto) {

        Interest entity = InterestMapper.toEntity(dto);
        return InterestMapper.toResponseDTO(interestRepository.save(entity));
    }

    @Override
    public InterestResponseDTO update(Integer id, InterestUpdateRequestDTO dto) {
        Interest entity = interestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found with id: " + id));

        InterestMapper.updateEntity(entity, dto);
        return InterestMapper.toResponseDTO(interestRepository.save(entity));
    }

    @Override
    public InterestResponseDTO findById(Integer id) {
        return interestRepository.findById(id)
                .map(InterestMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found with id: " + id));
    }

    @Override
    public List<InterestResponseDTO> findAll() {
        return interestRepository.findAll().stream()
                .map(InterestMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        if (!interestRepository.existsById(id)) {
            throw new ResourceNotFoundException("Interest not found with id: " + id);
        }
        interestRepository.deleteById(id);
    }


}