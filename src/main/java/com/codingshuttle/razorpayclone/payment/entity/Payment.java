package com.codingshuttle.razorpayclone.payment.entity;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "payment")
@Getter
@Setter
@Builder
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  OrderRecord orderRecord;

  @Column(nullable = false)
  UUID merchantId;

  @Embedded Money amount;

  String idempotencyKey;

  Long amountPaise;

  PaymentStatus status;

  PaymentMethod method;

  String processorRef;

  String errorMessage;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(columnDefinition = "jsonb")
  Map<String, Object> methodDetails;

  LocalDateTime authorizedAt;

  LocalDateTime capturedAt;

  LocalDateTime failedAt;
}
