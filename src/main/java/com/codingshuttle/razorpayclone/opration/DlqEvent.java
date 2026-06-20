package com.codingshuttle.razorpayclone.opration;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class DlqEvent {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @OneToOne
  @JoinColumn(name = "webhook_event_id", nullable = false)
  WebhookEvent webhookEvent;

  UUID merchantId;

  String finalError;

  LocalDateTime movedAt;
}
