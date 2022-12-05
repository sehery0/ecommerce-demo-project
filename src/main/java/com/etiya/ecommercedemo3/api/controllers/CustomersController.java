package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CustomerService;
import com.etiya.ecommercedemo3.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.customer.AddCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;
    @PostMapping("/add")
    public ResponseEntity<AddCustomerResponse> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest)
    {
        return new ResponseEntity<AddCustomerResponse>(customerService.addCustomer(addCustomerRequest), HttpStatus.CREATED);
    }
}
