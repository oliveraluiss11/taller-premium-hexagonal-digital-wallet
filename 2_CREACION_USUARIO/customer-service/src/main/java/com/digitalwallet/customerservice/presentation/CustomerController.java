package com.digitalwallet.customerservice.presentation;

import com.digitalwallet.customerservice.domain.CustomerCreation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    @PostMapping
    ResponseEntity<Void> createCustomer(@RequestBody CustomerCreation customerCreation){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
