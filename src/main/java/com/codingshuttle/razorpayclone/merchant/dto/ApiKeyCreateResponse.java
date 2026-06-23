package com.codingshuttle.razorpayclone.merchant.dto;

import com.codingshuttle.razorpayclone.common.enums.Environment;

public record ApiKeyCreateResponse(String keyId, String keySecretHash, Environment environment) {}
