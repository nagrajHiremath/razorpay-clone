package com.codingshuttle.razorpayclone.vault.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CardToken {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  String token;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vault_card_id")
  VaultCard vaultCard;

  UUID customerId;
  UUID merchantId;

  LocalDateTime createdAt;
}
