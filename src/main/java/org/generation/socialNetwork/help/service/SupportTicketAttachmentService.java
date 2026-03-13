package org.generation.socialNetwork.help.service;

import org.generation.socialNetwork.help.dto.SupportTicketAttachmentCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentUpdateRequestDTO;

import java.util.List;

public interface SupportTicketAttachmentService {

    SupportTicketAttachmentResponseDTO create(SupportTicketAttachmentCreateRequestDTO dto);

    SupportTicketAttachmentResponseDTO update(Long id, SupportTicketAttachmentUpdateRequestDTO dto);

    SupportTicketAttachmentResponseDTO findById(Long id);

    List<SupportTicketAttachmentResponseDTO> findAll();

    void delete(Long id);
}