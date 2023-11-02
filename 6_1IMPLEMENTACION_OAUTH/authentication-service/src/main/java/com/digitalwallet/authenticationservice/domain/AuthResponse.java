package com.digitalwallet.authenticationservice.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthResponse {
    String token;
}
