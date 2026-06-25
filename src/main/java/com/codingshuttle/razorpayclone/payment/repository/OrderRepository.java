package com.codingshuttle.razorpayclone.payment.repository;

import com.codingshuttle.razorpayclone.payment.entity.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderRecord, UUID> {
    OrderRecord findByIdAndMerchantId(UUID uuid, UUID merchantId);
}
