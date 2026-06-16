package com.codingshuttle.razorpayclone.merchant.entity;

import jakarta.persistence.*;

import java.util.UUID;

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false)
    Merchant merchant;

    String email;
    String passwordHash;
    String role;
}
