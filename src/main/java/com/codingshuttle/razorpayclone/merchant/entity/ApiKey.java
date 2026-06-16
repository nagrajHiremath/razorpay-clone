package com.codingshuttle.razorpayclone.merchant.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;
@Entity
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
    String webHookSecretHash;
    String environment;
    Boolean enabled;
    Instant lastUsedAt;
    Instant gracePeriodExpiresAt;
}
