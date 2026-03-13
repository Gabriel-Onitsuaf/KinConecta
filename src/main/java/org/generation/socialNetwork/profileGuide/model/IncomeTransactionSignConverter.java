package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class IncomeTransactionSignConverter extends LowercaseEnumAttributeConverter<IncomeTransactionSign> {

    public IncomeTransactionSignConverter() {
        super(IncomeTransactionSign.class);
    }
}
