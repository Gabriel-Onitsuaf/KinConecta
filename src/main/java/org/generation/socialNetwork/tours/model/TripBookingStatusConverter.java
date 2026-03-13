package org.generation.socialNetwork.tours.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class TripBookingStatusConverter extends LowercaseEnumAttributeConverter<TripBookingStatus> {

    public TripBookingStatusConverter() {
        super(TripBookingStatus.class);
    }
}
