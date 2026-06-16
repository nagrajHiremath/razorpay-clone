package com.codingshuttle.razorpayclone.payment;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    UUID merchantId;

    String idempotencyKey;

    @Embedded
    Money amountPaise;

    @Enumerated(EnumType.STRING)
    PaymentStatus status;

    Integer attempts;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    Map<String, Objects> notes;

    LocalDateTime expiresAt;

    String createdBy;

    String updatedBy;
}
