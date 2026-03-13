package org.generation.socialNetwork.profileGuide.model;

import jakarta.persistence.Converter;
import org.generation.socialNetwork.shared.persistence.LowercaseEnumAttributeConverter;

@Converter(autoApply = false)
public class WithdrawalRequestStatusConverter extends LowercaseEnumAttributeConverter<WithdrawalRequestStatus> {

    public WithdrawalRequestStatusConverter() {
        super(WithdrawalRequestStatus.class);
    }
}
