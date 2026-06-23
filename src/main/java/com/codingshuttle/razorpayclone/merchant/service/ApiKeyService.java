package com.codingshuttle.razorpayclone.merchant.service;

import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateRequest;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateResponse;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyResponse;
import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
  ApiKeyCreateResponse createApiKey(UUID merchantId, ApiKeyCreateRequest apiKeyCreateRequest);

  List<ApiKeyResponse> getApiKeyListByMerchantId(UUID merchantId);

  void revokeApiKey(UUID merchantId, UUID apiKeyId);

  ApiKeyCreateResponse rotateApiKey(UUID merchantId, UUID apiKeyId);
}
