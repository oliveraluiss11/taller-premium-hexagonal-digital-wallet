package com.digitalwallet.transferservice.movement.infrastructure;

import com.digitalwallet.transferservice.movement.domain.MovementCreationAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9003", name = "movement-service")
public interface MovementFeignClient {
    @PostMapping("/movements")
    ResponseEntity<Void> createMovement(@RequestBody MovementCreationAPI movement);

}
