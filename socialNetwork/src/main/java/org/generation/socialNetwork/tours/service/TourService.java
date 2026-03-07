package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.model.Tour;
import org.generation.socialNetwork.tours.model.TourDestinations;
import org.generation.socialNetwork.tours.repository.TourDestinationsRepository;
import org.generation.socialNetwork.tours.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    // Inyección de dependencias por constructor
    private final TourRepository tourRepository;
    private final TourDestinationsRepository tourDestinationsRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourDestinationsRepository tourDestinationsRepository) {
        this.tourRepository = tourRepository;
        this.tourDestinationsRepository = tourDestinationsRepository;
    }

    // Obtener todos los tours
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    // Obtener tour por ID
    public Tour getTourById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour no encontrado con id: " + id));
    }

    // Agregar nuevo tour
    public Tour addTour(Tour tour) {
        return tourRepository.save(tour);
    }

    // Eliminar tour por ID
    public Tour deleteTourById(Long id) {
        Tour tour = getTourById(id);
        tourRepository.deleteById(id);
        return tour;
    }

    // Actualizar tour por ID
    public Tour updateTourById(Long id, Tour updatedTour) {
        Tour existing = getTourById(id);

        existing.setGuideId(updatedTour.getGuideId());
        existing.setCategoryId(updatedTour.getCategoryId());
        existing.setTitle(updatedTour.getTitle());
        existing.setDescription(updatedTour.getDescription());
        existing.setPrice(updatedTour.getPrice());
        existing.setCurrency(updatedTour.getCurrency());
        existing.setDurationHours(updatedTour.getDurationHours());
        existing.setMaxGroupSize(updatedTour.getMaxGroupSize());
        existing.setMeetingPoint(updatedTour.getMeetingPoint());
        existing.setStatus(updatedTour.getStatus());
        existing.setCoverImage(updatedTour.getCoverImage());
        existing.setImageClass(updatedTour.getImageClass());
        existing.setRatingAvg(updatedTour.getRatingAvg());
        existing.setBookingsCount(updatedTour.getBookingsCount());

        return tourRepository.save(existing);
    }










    public Tour addTourDestination(Long idTour){
        Tour tour = tourRepository.findById(idTour).orElseThrow(
                () -> new IllegalArgumentException("El tour con el id " + idTour + " no existe.")
        );

        TourDestinations tourDestinations = new TourDestinations();

        tourDestinations.setTourId(idTour);
        tourDestinationsRepository.save(tourDestinations);
        tour.getTourDestinations().add(tourDestinations);
        return tourRepository.save(tour);

    }
}
