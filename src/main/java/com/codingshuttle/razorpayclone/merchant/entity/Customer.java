package com.codingshuttle.razorpayclone.merchant.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "merchant_id")
  Merchant merchant;

  String name;
  String email;
  String phone;
  String gstId;
}
