package com.digitalwallet.authenticationservice.application;

import com.digitalwallet.authenticationservice.domain.*;
import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Auth {
    private final CustomerRepository customerRepository;
    private final JwtGenerator jwtGenerator;
    private final JwtValidator jwtValidator;

    public AuthResponse signin(AuthRequest request) {
        Login login = new Login(request.getCredential(), request.getPin());
        String credential = login.getCredential();
        String pin = login.getPin();
        return customerRepository
                .findByCredential(credential)
                .map(customer -> {
                    if (!customer.getPin().equals(pin))
                        throw new DigitalWalletGenericClientException("Bad credentials"
                                , HttpStatus.UNAUTHORIZED);
                    String jwt = jwtGenerator.generateToken(customer.getPhoneNumber());
                    return AuthResponse.builder().token(jwt).build();
                })
                .orElseThrow(() -> new DigitalWalletGenericClientException("Customer not found"
                        , HttpStatus.NOT_FOUND));

    }

    public Customer validate(String token) {
        String phoneNumber = jwtValidator.validate(token);
        return customerRepository.findByCredential(phoneNumber)
                .orElseThrow(() -> new DigitalWalletGenericClientException("Bad credentials"
                        , HttpStatus.UNAUTHORIZED));
    }
}
