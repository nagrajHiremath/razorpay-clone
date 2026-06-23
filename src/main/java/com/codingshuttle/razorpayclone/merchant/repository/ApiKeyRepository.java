package com.codingshuttle.razorpayclone.merchant.repository;

import com.codingshuttle.razorpayclone.merchant.entity.ApiKey;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
  List<ApiKey> findByMerchantId(UUID merchantId);

  ApiKey findByMerchantIdAndKeyId(UUID merchantId, UUID apiKeyId);
}
