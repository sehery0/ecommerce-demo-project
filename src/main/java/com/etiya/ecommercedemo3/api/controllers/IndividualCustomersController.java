package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/individualCustomer")
@AllArgsConstructor
public class IndividualCustomersController {
    IndividualCustomerService individualCustomerService;

    @GetMapping("/getAll")
    public List<IndividualCustomer> getAll(){
        return individualCustomerService.getAll();
    }

    @GetMapping("{id}")
    public IndividualCustomer getById(@PathVariable int id){
        return individualCustomerService.getById(id);
    }

    @GetMapping("/firstName")
    public List<IndividualCustomer> getIndividualCustomerByFirstName(@RequestParam("firstName") String firstName){
        return individualCustomerService.getIndividualCustomerByFirstName(firstName);
    }

    @GetMapping("/nationalIdentity")
    public IndividualCustomer getIndividualCustomerBynationalIdentity(@RequestParam("nationalIdentity") String nationalIdentity){
        return individualCustomerService.getIndividualCustomerBynationalIdentity(nationalIdentity);
    }
}
