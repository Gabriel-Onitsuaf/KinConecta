package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class IncomeTransactionStatusConverter extends LowercaseEnumAttributeConverter<IncomeTransactionStatus> {

    public IncomeTransactionStatusConverter() {
        super(IncomeTransactionStatus.class);
    }
}
