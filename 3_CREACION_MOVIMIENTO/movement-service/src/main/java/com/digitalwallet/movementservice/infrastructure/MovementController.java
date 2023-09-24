package com.digitalwallet.movementservice.infrastructure;

import com.digitalwallet.movementservice.domain.MovementCreation;
import com.digitalwallet.movementservice.domain.MovementResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {
    @PostMapping
    public ResponseEntity<Void> createMovement(@RequestBody MovementCreation movement) {
        // Aquí implementarías la lógica para crear un nuevo movimiento en tu aplicación
        // Después de crear el movimiento, puedes devolver una respuesta con código 201 Created
        // y la ubicación del nuevo recurso en los encabezados de respuesta.


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint para obtener movimientos por walletId
    @GetMapping
    public ResponseEntity<List<MovementResponse>> getMovementsByWalletId(@RequestParam String walletId) {
        // Aquí implementarías la lógica para obtener movimientos por walletId
        // Debes llenar la lista "movements" con los resultados
        // Retorna los movimientos encontrados en una respuesta exitosa (200 OK)
        return ResponseEntity.ok(List.of());
    }
}
