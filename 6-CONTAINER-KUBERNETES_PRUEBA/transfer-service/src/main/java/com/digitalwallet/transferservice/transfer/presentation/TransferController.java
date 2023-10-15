package com.digitalwallet.transferservice.transfer.presentation;

import com.digitalwallet.transferservice.transfer.application.TransferExecutor;
import com.digitalwallet.transferservice.transfer.domain.TransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final TransferExecutor executor;

    @PostMapping()
    public ResponseEntity<Void> performTransfer(@RequestBody TransferRequest transferRequest) {
        executor.performTransfer(transferRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
