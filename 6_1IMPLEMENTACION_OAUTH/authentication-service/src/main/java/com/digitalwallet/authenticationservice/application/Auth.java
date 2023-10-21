package com.digitalwallet.authenticationservice.application;

import com.digitalwallet.authenticationservice.domain.AuthResponse;
import com.digitalwallet.authenticationservice.domain.CustomerRepository;
import com.digitalwallet.authenticationservice.domain.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Auth {
    private final CustomerRepository customerRepository;

    public AuthResponse login(Login login) {
        return null;
    }
}
