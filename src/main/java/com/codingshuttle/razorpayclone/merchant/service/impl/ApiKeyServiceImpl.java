package com.codingshuttle.razorpayclone.merchant.service.impl;

import com.codingshuttle.razorpayclone.common.enums.Environment;
import com.codingshuttle.razorpayclone.common.util.RandomizerUtil;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateRequest;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateResponse;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyResponse;
import com.codingshuttle.razorpayclone.merchant.entity.ApiKey;
import com.codingshuttle.razorpayclone.merchant.entity.Merchant;
import com.codingshuttle.razorpayclone.merchant.mapper.ApiKeyMapper;
import com.codingshuttle.razorpayclone.merchant.repository.ApiKeyRepository;
import com.codingshuttle.razorpayclone.merchant.repository.MerchantRepository;
import com.codingshuttle.razorpayclone.merchant.service.ApiKeyService;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApiKeyServiceImpl implements ApiKeyService {

  ApiKeyRepository apiKeyRepository;
  ApiKeyMapper apiKeyMapper;
  MerchantRepository merchantRepository;

  @Override
  public ApiKeyCreateResponse createApiKey(
      UUID merchantId, ApiKeyCreateRequest apiKeyCreateRequest) {

    Merchant merchant = merchantRepository.findById(merchantId).orElseThrow();

    String keyId =
        "rzp"
            + apiKeyCreateRequest.environment().name().toLowerCase()
            + "_"
            + RandomizerUtil.randomBase64(24);

    ApiKey apiKey =
        ApiKey.builder()
            .keySecretHash(RandomizerUtil.randomBase64(40))
            .environment(Environment.LIVE)
            .merchant(merchant)
            .keyId(keyId)
            .build();

    apiKeyRepository.save(apiKey);

    return apiKeyMapper.toApikeyCreateResponse(apiKey);
  }

  @Override
  public List<ApiKeyResponse> getApiKeyListByMerchantId(UUID merchantId) {
    List<ApiKey> apiKeyList = apiKeyRepository.findByMerchantId(merchantId);

    return apiKeyMapper.toApiResponseList(apiKeyList);
  }

  @Override
  public void revokeApiKey(UUID merchantId, UUID apiKeyId) {
    ApiKey apiKey = apiKeyRepository.findByMerchantIdAndKeyId(merchantId, apiKeyId);
    apiKey.setEnabled(false);
    apiKeyRepository.save(apiKey);
  }

  @Override
  public ApiKeyCreateResponse rotateApiKey(UUID merchantId, UUID apiKeyId) {
    ApiKey apiKey = apiKeyRepository.findByMerchantIdAndKeyId(merchantId, apiKeyId);

    apiKey.setPreviousKeySecretHash(apiKey.getKeySecretHash());
    apiKey.setRotatedAt(Instant.now());
    apiKey.setKeySecretHash(RandomizerUtil.randomBase64(40));
    apiKey.setGracePeriodExpiresAt(LocalTime.now().plusHours(24));

    apiKeyRepository.save(apiKey);

    return apiKeyMapper.toApikeyCreateResponse(apiKey);
  }
}
