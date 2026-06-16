package com.codingshuttle.razorpayclone.payment;

import com.codingshuttle.razorpayclone.common.enums.PaymentActor;
import com.codingshuttle.razorpayclone.common.enums.PaymentEvent;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    Payment payment;

    @Enumerated(EnumType.STRING)
    PaymentStatus fromStatus;

    String toStatus;

    @Enumerated(EnumType.STRING)
    PaymentEvent eventType;

    @Enumerated(EnumType.STRING)
    PaymentActor actor;

    String reason;

    LocalDateTime occurredAt;
}
