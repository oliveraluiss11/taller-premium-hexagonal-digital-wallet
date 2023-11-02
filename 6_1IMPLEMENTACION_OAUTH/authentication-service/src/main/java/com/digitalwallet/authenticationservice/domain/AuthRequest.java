package com.digitalwallet.authenticationservice.domain;

import lombok.Getter;

@Getter
public class AuthRequest {
    private String credential;
    private String pin;
}
