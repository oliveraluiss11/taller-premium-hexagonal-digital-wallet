package com.digitalwallet.transferservice.transfer.presentation;

import com.digitalwallet.transferservice.transfer.domain.TransferRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @PostMapping("/transfer")
    public ResponseEntity<String> performTransfer(TransferRequest transferRequest) {
        return new ResponseEntity<>("Transferencia exitosa", HttpStatus.CREATED);
    }
}
