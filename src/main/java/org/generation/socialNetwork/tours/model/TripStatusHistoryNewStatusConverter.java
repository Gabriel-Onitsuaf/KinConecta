package org.generation.socialNetwork.tours.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class TripStatusHistoryNewStatusConverter extends LowercaseEnumAttributeConverter<TripStatusHistoryNewStatus> {

    public TripStatusHistoryNewStatusConverter() {
        super(TripStatusHistoryNewStatus.class);
    }
}
