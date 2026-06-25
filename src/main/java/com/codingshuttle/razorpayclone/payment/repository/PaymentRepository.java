package com.codingshuttle.razorpayclone.payment.repository;

import com.codingshuttle.razorpayclone.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
