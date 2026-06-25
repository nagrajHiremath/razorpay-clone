package com.codingshuttle.razorpayclone.payment.entity;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.OrderStatus;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Setter
@Builder
public class OrderRecord {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  UUID merchantId;

  String idempotencyKey;

  @Embedded Money amountPaise;

  @Enumerated(EnumType.STRING)
  OrderStatus status;

  Integer attempts;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(columnDefinition = "jsonb")
  Map<String, Objects> notes;

  LocalDateTime expiresAt;

  String createdBy;

  String updatedBy;
}
