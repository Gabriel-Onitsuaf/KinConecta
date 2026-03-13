package org.generation.socialNetwork.help.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketAttachmentUpdateRequestDTO;
import org.generation.socialNetwork.help.model.SupportTicketAttachment;
import org.generation.socialNetwork.help.repository.SupportTicketAttachmentRepository;
import org.generation.socialNetwork.help.repository.SupportTicketRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportTicketAttachmentServiceImpl implements SupportTicketAttachmentService {

    private final SupportTicketAttachmentRepository supportTicketAttachmentRepository;
    private final SupportTicketRepository supportTicketRepository;

    @Override
    public SupportTicketAttachmentResponseDTO create(SupportTicketAttachmentCreateRequestDTO dto) {
        validateSupportTicketExists(dto.getTicketId(), "ticketId");
        SupportTicketAttachment entity = SupportTicketAttachmentMapper.toEntity(dto);
        return SupportTicketAttachmentMapper.toResponseDTO(supportTicketAttachmentRepository.save(entity));
    }

    @Override
    public SupportTicketAttachmentResponseDTO update(Long id, SupportTicketAttachmentUpdateRequestDTO dto) {
        SupportTicketAttachment entity = supportTicketAttachmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupportTicketAttachment not found with id: " + id));
        validateSupportTicketExists(dto.getTicketId(), "ticketId");
        SupportTicketAttachmentMapper.updateEntity(entity, dto);
        return SupportTicketAttachmentMapper.toResponseDTO(supportTicketAttachmentRepository.save(entity));
    }

    @Override
    public SupportTicketAttachmentResponseDTO findById(Long id) {
        return supportTicketAttachmentRepository.findById(id)
                .map(SupportTicketAttachmentMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("SupportTicketAttachment not found with id: " + id));
    }

    @Override
    public List<SupportTicketAttachmentResponseDTO> findAll() {
        return supportTicketAttachmentRepository.findAll().stream()
                .map(SupportTicketAttachmentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!supportTicketAttachmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("SupportTicketAttachment not found with id: " + id);
        }
        supportTicketAttachmentRepository.deleteById(id);
    }

    private void validateSupportTicketExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!supportTicketRepository.existsById(id)) {
            throw new ResourceNotFoundException("SupportTicket not found for " + fieldName + ": " + id);
        }
    }
}