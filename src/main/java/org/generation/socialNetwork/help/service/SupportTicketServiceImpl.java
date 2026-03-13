package org.generation.socialNetwork.help.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.help.dto.SupportTicketCreateRequestDTO;
import org.generation.socialNetwork.help.dto.SupportTicketResponseDTO;
import org.generation.socialNetwork.help.dto.SupportTicketUpdateRequestDTO;
import org.generation.socialNetwork.help.model.SupportTicket;
import org.generation.socialNetwork.help.repository.SupportTicketRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportTicketServiceImpl implements SupportTicketService {

    private final SupportTicketRepository supportTicketRepository;
    private final UserRepository userRepository;

    @Override
    public SupportTicketResponseDTO create(SupportTicketCreateRequestDTO dto) {
        validateUserExists(dto.getUserId(), "userId");
        SupportTicket entity = SupportTicketMapper.toEntity(dto);
        return SupportTicketMapper.toResponseDTO(supportTicketRepository.save(entity));
    }

    @Override
    public SupportTicketResponseDTO update(Long id, SupportTicketUpdateRequestDTO dto) {
        SupportTicket entity = supportTicketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupportTicket not found with id: " + id));
        validateUserExists(dto.getUserId(), "userId");
        SupportTicketMapper.updateEntity(entity, dto);
        return SupportTicketMapper.toResponseDTO(supportTicketRepository.save(entity));
    }

    @Override
    public SupportTicketResponseDTO findById(Long id) {
        return supportTicketRepository.findById(id)
                .map(SupportTicketMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("SupportTicket not found with id: " + id));
    }

    @Override
    public List<SupportTicketResponseDTO> findAll() {
        return supportTicketRepository.findAll().stream()
                .map(SupportTicketMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!supportTicketRepository.existsById(id)) {
            throw new ResourceNotFoundException("SupportTicket not found with id: " + id);
        }
        supportTicketRepository.deleteById(id);
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