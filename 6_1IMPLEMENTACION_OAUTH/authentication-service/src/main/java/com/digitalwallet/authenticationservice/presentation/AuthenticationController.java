package com.digitalwallet.authenticationservice.presentation;

import com.digitalwallet.authenticationservice.application.Auth;
import com.digitalwallet.authenticationservice.domain.AuthRequest;
import com.digitalwallet.authenticationservice.domain.AuthResponse;
import com.digitalwallet.authenticationservice.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final Auth auth;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(auth.signin(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<Customer> validate(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(auth.validate(token));
    }
}
