package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CustomerService;
import com.etiya.ecommercedemo3.entities.concretes.Customer;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;
    @GetMapping("/getById")
    public Customer getById(@RequestParam("id") int id){
        return customerService.getById(id);
    }
    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
