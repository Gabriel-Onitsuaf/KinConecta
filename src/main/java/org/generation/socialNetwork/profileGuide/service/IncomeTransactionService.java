package org.generation.socialNetwork.profileGuide.service;

import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.IncomeTransactionUpdateRequestDTO;

import java.util.List;

public interface IncomeTransactionService {

    IncomeTransactionResponseDTO create(IncomeTransactionCreateRequestDTO dto);

    IncomeTransactionResponseDTO update(Long id, IncomeTransactionUpdateRequestDTO dto);

    IncomeTransactionResponseDTO findById(Long id);

    List<IncomeTransactionResponseDTO> findAll();

    void delete(Long id);
}