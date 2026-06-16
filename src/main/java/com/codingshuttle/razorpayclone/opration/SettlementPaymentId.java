package com.codingshuttle.razorpayclone.opration;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId {
    UUID settlementId;
    UUID paymentId;
}
