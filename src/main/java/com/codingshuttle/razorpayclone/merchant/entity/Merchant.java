package com.codingshuttle.razorpayclone.merchant.entity;

import com.codingshuttle.razorpayclone.common.enums.MerchantStatus;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Merchant {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @Column(length = 20)
  String name;

  String businessName;
  String email;
  MerchantStatus merchantStatus;
  String gstId;
  String panId;
  String settlementBankAccount;
  String settlementBankIfsc;
  String settlementAccountHolderName;
  String createdBy;
  String updatedBy;
}
