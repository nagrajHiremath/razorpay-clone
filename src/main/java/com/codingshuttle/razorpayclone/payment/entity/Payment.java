package com.codingshuttle.razorpayclone.payment.entity;

import com.codingshuttle.razorpayclone.common.entity.Money;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "payment")
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

  String status;

  String method;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(columnDefinition = "jsonb")
  Map<String, Object> methodDetails;

  LocalDateTime authorizedAt;

  LocalDateTime capturedAt;

  LocalDateTime failedAt;
}
