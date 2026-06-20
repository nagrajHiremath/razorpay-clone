package com.codingshuttle.razorpayclone.merchant.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class MerchantWebhookConfig {
  @Id UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "merchant_id", nullable = false)
  Merchant merchant;

  String targetUrl;
  String eventTypeFilter;
  Boolean enabled;
  String webhookSecret;
}
