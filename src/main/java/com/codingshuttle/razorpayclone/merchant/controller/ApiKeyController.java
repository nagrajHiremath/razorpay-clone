package com.codingshuttle.razorpayclone.merchant.controller;

import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateRequest;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateResponse;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyResponse;
import com.codingshuttle.razorpayclone.merchant.service.ApiKeyService;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/merchant/{merchantId}/api-key")
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApiKeyController {

  ApiKeyService apiKeyService;

  @PostMapping
  public ResponseEntity<ApiKeyCreateResponse> createApiKey(
      UUID merchantId, ApiKeyCreateRequest apiKeyCreateRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(apiKeyService.createApiKey(merchantId, apiKeyCreateRequest));
  }

  @GetMapping
  public ResponseEntity<List<ApiKeyResponse>> getApiKeyListByMerchantId(UUID merchantId) {
    return ResponseEntity.ok(apiKeyService.getApiKeyListByMerchantId(merchantId));
  }

  @DeleteMapping
  public ResponseEntity<Void> revokeApiKey(UUID merchantId, UUID apiKeyId) {
    apiKeyService.revokeApiKey(merchantId, apiKeyId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/rotate")
  public ResponseEntity<ApiKeyCreateResponse> rotateApiKey(UUID merchantId, UUID apiKeyId) {
    return ResponseEntity.ok(apiKeyService.rotateApiKey(merchantId, apiKeyId));
  }
}
