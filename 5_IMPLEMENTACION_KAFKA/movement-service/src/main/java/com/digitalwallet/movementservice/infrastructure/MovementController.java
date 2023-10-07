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
    private final FindMovementByWalletId findMovementByWalletId;

    @GetMapping
    public ResponseEntity<List<MovementResponse>> getMovementsByWalletId(@RequestParam String walletId) {
        return ResponseEntity.ok(findMovementByWalletId.findMovements(walletId));
    }
}
