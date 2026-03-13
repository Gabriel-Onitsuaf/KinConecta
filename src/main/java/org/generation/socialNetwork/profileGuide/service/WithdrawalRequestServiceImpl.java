package org.generation.socialNetwork.profileGuide.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.model.WithdrawalRequest;
import org.generation.socialNetwork.profileGuide.repository.WithdrawalRequestRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WithdrawalRequestServiceImpl implements WithdrawalRequestService {

    private final WithdrawalRequestRepository withdrawalRequestRepository;
    private final UserRepository userRepository;

    @Override
    public WithdrawalRequestResponseDTO create(WithdrawalRequestCreateRequestDTO dto) {
        validateUserExists(dto.getGuideId(), "guideId");
        validateUserExists(dto.getProcessedByUserId(), "processedByUserId");
        WithdrawalRequest entity = WithdrawalRequestMapper.toEntity(dto);
        return WithdrawalRequestMapper.toResponseDTO(withdrawalRequestRepository.save(entity));
    }

    @Override
    public WithdrawalRequestResponseDTO update(Long id, WithdrawalRequestUpdateRequestDTO dto) {
        WithdrawalRequest entity = withdrawalRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WithdrawalRequest not found with id: " + id));
        validateUserExists(dto.getGuideId(), "guideId");
        validateUserExists(dto.getProcessedByUserId(), "processedByUserId");
        WithdrawalRequestMapper.updateEntity(entity, dto);
        return WithdrawalRequestMapper.toResponseDTO(withdrawalRequestRepository.save(entity));
    }

    @Override
    public WithdrawalRequestResponseDTO findById(Long id) {
        return withdrawalRequestRepository.findById(id)
                .map(WithdrawalRequestMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("WithdrawalRequest not found with id: " + id));
    }

    @Override
    public List<WithdrawalRequestResponseDTO> findAll() {
        return withdrawalRequestRepository.findAll().stream()
                .map(WithdrawalRequestMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!withdrawalRequestRepository.existsById(id)) {
            throw new ResourceNotFoundException("WithdrawalRequest not found with id: " + id);
        }
        withdrawalRequestRepository.deleteById(id);
    }

    private void validateUserExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found for " + fieldName + ": " + id);
        }
    }
}