package com.digitalwallet.movementservice.infrastructure;

import com.digitalwallet.movementservice.application.FindMovementByWalletId;
import com.digitalwallet.movementservice.application.RegisterMovement;
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
    private final RegisterMovement registerMovement;
    private final FindMovementByWalletId findMovementByWalletId;
    @PostMapping
    public ResponseEntity<Void> createMovement(@RequestBody MovementCreation movement) {
        this.registerMovement.registered(movement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovementResponse>> getMovementsByWalletId(@RequestParam String walletId) {
        return ResponseEntity.ok(findMovementByWalletId.findMovements(walletId));
    }
}
