package com.codingshuttle.razorpayclone.opration.entity;

import com.codingshuttle.razorpayclone.common.enums.PaymentEvent;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class WebhookEvent {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  UUID merchantId;

  @Enumerated(EnumType.STRING)
  PaymentEvent event;

  String targetUrl;
}
