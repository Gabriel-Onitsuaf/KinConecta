package org.generation.socialNetwork.tours.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.tours.dto.TourCategoryCreateRequestDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryResponseDTO;
import org.generation.socialNetwork.tours.dto.TourCategoryUpdateRequestDTO;
import org.generation.socialNetwork.tours.model.TourCategory;
import org.generation.socialNetwork.tours.repository.TourCategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourCategoryServiceImpl implements TourCategoryService {

    private final TourCategoryRepository tourCategoryRepository;

    @Override
    public TourCategoryResponseDTO create(TourCategoryCreateRequestDTO dto) {

        TourCategory entity = TourCategoryMapper.toEntity(dto);
        return TourCategoryMapper.toResponseDTO(tourCategoryRepository.save(entity));
    }

    @Override
    public TourCategoryResponseDTO update(Integer id, TourCategoryUpdateRequestDTO dto) {
        TourCategory entity = tourCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourCategory not found with id: " + id));

        TourCategoryMapper.updateEntity(entity, dto);
        return TourCategoryMapper.toResponseDTO(tourCategoryRepository.save(entity));
    }

    @Override
    public TourCategoryResponseDTO findById(Integer id) {
        return tourCategoryRepository.findById(id)
                .map(TourCategoryMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("TourCategory not found with id: " + id));
    }

    @Override
    public List<TourCategoryResponseDTO> findAll() {
        return tourCategoryRepository.findAll().stream()
                .map(TourCategoryMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        if (!tourCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("TourCategory not found with id: " + id);
        }
        tourCategoryRepository.deleteById(id);
    }


}