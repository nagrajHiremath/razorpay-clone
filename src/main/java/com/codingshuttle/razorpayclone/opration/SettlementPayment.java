package com.codingshuttle.razorpayclone.opration;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SettlementPayment {

    @EmbeddedId
    SettlementPaymentId settlementPaymentId;

}
