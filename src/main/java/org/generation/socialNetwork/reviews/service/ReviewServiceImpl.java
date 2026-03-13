package org.generation.socialNetwork.reviews.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.generation.socialNetwork.configuration.exception.ResourceNotFoundException;
import org.generation.socialNetwork.reviews.dto.ReviewCreateRequestDTO;
import org.generation.socialNetwork.reviews.dto.ReviewResponseDTO;
import org.generation.socialNetwork.reviews.dto.ReviewUpdateRequestDTO;
import org.generation.socialNetwork.reviews.model.Review;
import org.generation.socialNetwork.reviews.repository.ReviewRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.generation.socialNetwork.tours.repository.TripBookingRepository;
import org.generation.socialNetwork.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final TripBookingRepository tripBookingRepository;
    private final TourRepository tourRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewResponseDTO create(ReviewCreateRequestDTO dto) {
        validateTripBookingExists(dto.getTripId(), "tripId");
        validateTourExists(dto.getTourId(), "tourId");
        validateUserExists(dto.getGuideId(), "guideId");
        validateUserExists(dto.getTouristId(), "touristId");
        Review entity = ReviewMapper.toEntity(dto);
        return ReviewMapper.toResponseDTO(reviewRepository.save(entity));
    }

    @Override
    public ReviewResponseDTO update(Long id, ReviewUpdateRequestDTO dto) {
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        validateTripBookingExists(dto.getTripId(), "tripId");
        validateTourExists(dto.getTourId(), "tourId");
        validateUserExists(dto.getGuideId(), "guideId");
        validateUserExists(dto.getTouristId(), "touristId");
        ReviewMapper.updateEntity(entity, dto);
        return ReviewMapper.toResponseDTO(reviewRepository.save(entity));
    }

    @Override
    public ReviewResponseDTO findById(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
    }

    @Override
    public List<ReviewResponseDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(ReviewMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }

    private void validateTripBookingExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tripBookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("TripBooking not found for " + fieldName + ": " + id);
        }
    }
    private void validateTourExists(Long id, String fieldName) {
        if (id == null) {
            return;
        }
        if (!tourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tour not found for " + fieldName + ": " + id);
        }
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