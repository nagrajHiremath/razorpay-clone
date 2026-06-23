package com.codingshuttle.razorpayclone.opration.entity;

import jakarta.persistence.*;

@Entity
public class SettlementPayment {

  @EmbeddedId SettlementPaymentId settlementPaymentId;
}
