package com.codingshuttle.razorpayclone.merchant.entity;

import com.codingshuttle.razorpayclone.common.enums.Environment;
import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class ApiKey {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @ManyToOne
  @JoinColumn(name = "merchant_id", nullable = false)
  Merchant merchant;

  @Column(nullable = false)
  String keyId;

  String keySecretHash;
  String previousKeySecretHash;
  String webHookSecretHash;
  Environment environment;
  Boolean enabled;
  Instant lastUsedAt;
  Instant rotatedAt;
  LocalTime gracePeriodExpiresAt;
}
