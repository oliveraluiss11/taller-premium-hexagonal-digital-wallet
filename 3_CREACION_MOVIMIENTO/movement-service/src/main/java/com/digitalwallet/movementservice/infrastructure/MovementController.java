package com.digitalwallet.movementservice.infrastructure;

import com.digitalwallet.movementservice.application.RegisteredMovement;
import com.digitalwallet.movementservice.domain.MovementCreation;
import com.digitalwallet.movementservice.domain.MovementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
@RequiredArgsConstructor
public class MovementController {
    private final RegisteredMovement registeredMovement;
    @PostMapping
    public ResponseEntity<Void> createMovement(@RequestBody MovementCreation movement) {
        this.registeredMovement.registered(movement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovementResponse>> getMovementsByWalletId(@RequestParam String walletId) {
        return ResponseEntity.ok(List.of());
    }
}
