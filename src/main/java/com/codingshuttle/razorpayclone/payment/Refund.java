package com.codingshuttle.razorpayclone.payment;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Refund {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_id", nullable = false)
  Payment payment;

  UUID merchantId;

  @Embedded Money amountPaise;

  @Enumerated(EnumType.STRING)
  PaymentStatus status;

  String bankReference;

  String errorCode;

  LocalDateTime processedAt;
}
