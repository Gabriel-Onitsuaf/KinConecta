package org.generation.socialNetwork.tours.service;

import org.generation.socialNetwork.tours.model.Destinations;
import org.generation.socialNetwork.tours.model.Tour;
import org.generation.socialNetwork.tours.model.TourDestinations;
import org.generation.socialNetwork.tours.repository.DestinationsRepository;
import org.generation.socialNetwork.tours.repository.TourDestinationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationsService {

    // Inyección de dependencias por constructor
    private final DestinationsRepository destinationsRepository;
    private final TourDestinationsRepository tourDestinationsRepository;

    @Autowired
    public DestinationsService(DestinationsRepository destinationsRepository, TourDestinationsRepository tourDestinationsRepository) {
        this.destinationsRepository = destinationsRepository;
        this.tourDestinationsRepository = tourDestinationsRepository;
    }

    // Obtener todas los lugares de destino
    public List<Destinations> getAllDestinations() {
        return destinationsRepository.findAll();
    }

    // Obtener lugar de destino por ID
    public Destinations getDestinationsById(Long destinationId) {
        return destinationsRepository.findById(destinationId).orElseThrow(
                () -> new RuntimeException("Lugar de destino no encontrado con id: " + destinationId)
        );
    }

    // Agregar nuevo lugar de destino
    public Destinations addDestinations(Destinations destinations) {
        return destinationsRepository.save(destinations);
    }

    // Eliminar lugar de destino por ID
    public Destinations deleteDestinationById(Long destinationId) {
        Destinations destinations = getDestinationsById(destinationId);
        destinationsRepository.deleteById(destinationId);
        return destinations;
    }

    // Actualizar reservación por ID
    public Destinations updateDestinationsById(Long destinationId, Destinations updatedDestinations) {
        Destinations existing = getDestinationsById(destinationId);

        existing.setCity(updatedDestinations.getCity());
        existing.setCountry(updatedDestinations.getCountry());
        existing.setDescription(updatedDestinations.getDescription()); //Viene del front end
        existing.setFavorite(updatedDestinations.getFavorite());

        return destinationsRepository.save(existing);
    }

    public Destinations addTourDestination(Long idDestinations){
        Destinations destinations = destinationsRepository.findById(idDestinations).orElseThrow(
                () -> new IllegalArgumentException("El destino con el id " + idDestinations + " no existe.")
        );

        TourDestinations tourDestinations = new TourDestinations();

        tourDestinations.setDestinationId(idDestinations);
        tourDestinationsRepository.save(tourDestinations);
        destinations.getTourDestinations().add(tourDestinations);
        return destinationsRepository.save(destinations);

    }
}
