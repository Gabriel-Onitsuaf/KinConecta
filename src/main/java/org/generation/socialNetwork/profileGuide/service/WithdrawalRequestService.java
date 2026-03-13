package org.generation.socialNetwork.profileGuide.service;

import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestCreateRequestDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestResponseDTO;
import org.generation.socialNetwork.profileGuide.dto.WithdrawalRequestUpdateRequestDTO;

import java.util.List;

public interface WithdrawalRequestService {

    WithdrawalRequestResponseDTO create(WithdrawalRequestCreateRequestDTO dto);

    WithdrawalRequestResponseDTO update(Long id, WithdrawalRequestUpdateRequestDTO dto);

    WithdrawalRequestResponseDTO findById(Long id);

    List<WithdrawalRequestResponseDTO> findAll();

    void delete(Long id);
}