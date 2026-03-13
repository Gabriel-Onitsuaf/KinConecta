package org.generation.socialNetwork.help.service;

import org.generation.socialNetwork.help.dto.SupportTicketCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketUpdateRequestDTO;

import java.util.List;

public interface SupportTicketService {

    SupportTicketResponseDTO create(SupportTicketCreateRequestDTO dto);

    SupportTicketResponseDTO update(Long id, SupportTicketUpdateRequestDTO dto);

    SupportTicketResponseDTO findById(Long id);

    List<SupportTicketResponseDTO> findAll();

    void delete(Long id);
}