package org.generation.socialNetwork.tours.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class TripStatusHistoryOldStatusConverter extends LowercaseEnumAttributeConverter<TripStatusHistoryOldStatus> {

    public TripStatusHistoryOldStatusConverter() {
        super(TripStatusHistoryOldStatus.class);
    }
}
