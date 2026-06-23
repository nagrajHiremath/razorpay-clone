package com.codingshuttle.razorpayclone.merchant.dto;

import com.codingshuttle.razorpayclone.common.enums.Environment;
import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;

public record ApiKeyResponse(
    UUID id,
    UUID merchantId,
    String keyId,
    String keySecretHash,
    String previousKeySecretHash,
    String webHookSecretHash,
    Environment environment,
    Boolean enabled,
    Instant lastUsedAt,
    Instant rotatedAt,
    LocalTime gracePeriodExpiresAt) {}
