package com.codingshuttle.razorpayclone.merchant.repository;

import com.codingshuttle.razorpayclone.merchant.entity.Merchant;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    boolean findByEmail(String email);
}
