package org.generation.socialNetwork.profileGuide.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionUpdateRequestDTO;
import org.generation.socialNetwork.profileGuide.model.IncomeTransaction;
import org.generation.socialNetwork.profileGuide.repository.IncomeTransactionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeTransactionServiceImpl implements IncomeTransactionService {

    private final IncomeTransactionRepository incomeTransactionRepository;

    @Override
    public IncomeTransactionResponseDTO create(IncomeTransactionCreateRequestDTO dto) {

        IncomeTransaction entity = IncomeTransactionMapper.toEntity(dto);
        return IncomeTransactionMapper.toResponseDTO(incomeTransactionRepository.save(entity));
    }

    @Override
    public IncomeTransactionResponseDTO update(Long id, IncomeTransactionUpdateRequestDTO dto) {
        IncomeTransaction entity = incomeTransactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncomeTransaction not found with id: " + id));

        IncomeTransactionMapper.updateEntity(entity, dto);
        return IncomeTransactionMapper.toResponseDTO(incomeTransactionRepository.save(entity));
    }

    @Override
    public IncomeTransactionResponseDTO findById(Long id) {
        return incomeTransactionRepository.findById(id)
                .map(IncomeTransactionMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("IncomeTransaction not found with id: " + id));
    }

    @Override
    public List<IncomeTransactionResponseDTO> findAll() {
        return incomeTransactionRepository.findAll().stream()
                .map(IncomeTransactionMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!incomeTransactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("IncomeTransaction not found with id: " + id);
        }
        incomeTransactionRepository.deleteById(id);
    }


}