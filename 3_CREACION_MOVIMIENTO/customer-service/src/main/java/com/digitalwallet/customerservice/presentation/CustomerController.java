package com.digitalwallet.customerservice.presentation;

import com.digitalwallet.customerservice.application.CreateCustomerByPersonalInformation;
import com.digitalwallet.customerservice.domain.CustomerCreation;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomerByPersonalInformation createCustomerByPersonalInformation;
    @PostMapping
    ResponseEntity<Void> createCustomer(@RequestBody CustomerCreation customerCreation){
        createCustomerByPersonalInformation.register(customerCreation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
