package com.codingshuttle.razorpayclone.merchant.entity;

import com.codingshuttle.razorpayclone.common.enums.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "merchant_id", nullable = false)
  Merchant merchant;

  String email;
  String passwordHash;
  UserRole role;
}
