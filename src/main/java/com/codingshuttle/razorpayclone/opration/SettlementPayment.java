package com.codingshuttle.razorpayclone.opration;

import jakarta.persistence.*;

@Entity
public class SettlementPayment {

  @EmbeddedId SettlementPaymentId settlementPaymentId;
}
