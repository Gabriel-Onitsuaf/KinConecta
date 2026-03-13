package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class IncomeTransactionTxnTypeConverter extends LowercaseEnumAttributeConverter<IncomeTransactionTxnType> {

    public IncomeTransactionTxnTypeConverter() {
        super(IncomeTransactionTxnType.class);
    }
}
