package com.codingshuttle.razorpayclone.opration;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Settlement {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  UUID merchantId;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "amountUnits",
        column = @Column(name = "gross_amount_units", nullable = false)),
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "gross_amount_currency", nullable = false))
  })
  Money grossAmount;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "amountUnits",
        column = @Column(name = "refund_amount_units", nullable = false)),
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "refund_amount_currency", nullable = false))
  })
  Money refundAmount;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "amountUnits",
        column = @Column(name = "fee_amount_units", nullable = false)),
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "fee_amount_currency", nullable = false))
  })
  Money feeAmount;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "amountUnits",
        column = @Column(name = "gst_amount_units", nullable = false)),
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "gst_amount_currency", nullable = false))
  })
  Money gstAmount;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "amountUnits",
        column = @Column(name = "net_amount_units", nullable = false)),
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "net_amount_currency", nullable = false))
  })
  Money netAmount;

  @Enumerated(EnumType.STRING)
  PaymentStatus status;

  LocalDateTime processedAt;
}
