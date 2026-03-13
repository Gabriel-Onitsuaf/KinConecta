package org.generation.socialNetwork.profileGuide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "income_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class IncomeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "guide_id")
    private Long guideId;

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "tour_id")
    private Long tourId;

    @Convert(converter = IncomeTransactionTxnTypeConverter.class)
    @Column(name = "txn_type")
    private IncomeTransactionTxnType txnType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Convert(converter = IncomeTransactionSignConverter.class)
    @Column(name = "sign")
    private IncomeTransactionSign sign;

    @Convert(converter = IncomeTransactionStatusConverter.class)
    @Column(name = "status")
    private IncomeTransactionStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "occurred_at")
    private LocalDateTime occurredAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
