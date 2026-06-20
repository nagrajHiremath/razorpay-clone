package com.codingshuttle.razorpayclone.vault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class VaultCard {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  byte[] encryptedPan;
  byte[] encryptedDek;

  LocalDateTime createdAt;
}
